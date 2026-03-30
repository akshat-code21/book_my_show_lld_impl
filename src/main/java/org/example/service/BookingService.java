package org.example.service;

import org.example.entity.*;
import org.example.enums.BookingStatus;
import org.example.enums.SeatStatus;
import org.example.payment.PaymentGateway;
import org.example.repository.MovieRepository;
import org.example.repository.ShowRepository;
import org.example.repository.TheatreRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookingService {
    private final TheatreRepository tr;
    private final MovieRepository mr;
    private final ShowRepository sr;
    private final PaymentGateway paymentGateway;
    private final PricingCalculatorService pricing;

    public BookingService(TheatreRepository tr, MovieRepository mr, ShowRepository sr, PaymentGateway paymentGateway, PricingCalculatorService pricing) {
        this.tr = tr;
        this.mr = mr;
        this.sr = sr;
        this.paymentGateway = paymentGateway;
        this.pricing = pricing;
    }

    public MovieTicket bookTicket(String showId, List<ShowSeat> seats, User user) {
        Show show = sr.getShow(showId);
        if (show.getShowTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Cannot book ticket for a past show");
        }

        if (seats == null || seats.isEmpty()) {
            throw new RuntimeException("No seats selected");
        }

        List<ShowSeat> sortedSeats = seats.stream()
                .sorted(Comparator.comparing(ss -> ss.getSeat().getId()))
                .toList();

        for (ShowSeat ss : sortedSeats) {
            synchronized (ss) {
                if (ss.getStatus() != SeatStatus.VACANT) {
                    throw new RuntimeException("Seat " + ss.getSeat().getId() + " is not available");
                }
                ss.setStatus(SeatStatus.IN_PROGRESS);
            }
        }

        for (ShowSeat ss : seats) {
            int price = pricing.calculatePrice(ss);
            ss.setPrice(price);
        }

        int totalPrice = seats.stream().mapToInt(ShowSeat::getPrice).sum();

        MovieTicket ticket = new MovieTicket(
                UUID.randomUUID().toString(), seats,
                sr.getShow(showId), user, totalPrice, BookingStatus.PENDING
        );

        try {
            paymentGateway.processPayment(totalPrice);
            for (ShowSeat ss : seats) {
                ss.setStatus(SeatStatus.BOOKED);
            }
            ticket.setBookingStatus(BookingStatus.CONFIRMED);
        } catch (Exception e) {
            for (ShowSeat ss : seats) {
                ss.setStatus(SeatStatus.VACANT);
            }
            ticket.setBookingStatus(BookingStatus.FAILED);
        }


        return ticket;
    }

    List<Theatre> showTheatres(City c) {
        return tr.getTheatres(c);
    }

    List<Movie> showMovies(City c) {
        return mr.getMovies(c);
    }

    public List<ShowSeat> showSeatMap(String showId) {
        return sr.getShow(showId).getSeats();
    }
}
