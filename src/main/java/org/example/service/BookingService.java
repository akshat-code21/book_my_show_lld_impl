package org.example.service;

import org.example.entity.*;
import org.example.enums.BookingStatus;
import org.example.enums.SeatStatus;
import org.example.repository.MovieRepository;
import org.example.repository.ShowRepository;
import org.example.repository.TheatreRepository;

import java.util.List;
import java.util.UUID;

public class BookingService {
    private final TheatreRepository tr;
    private final MovieRepository mr;
    private ShowRepository sr;

    public BookingService(TheatreRepository tr, MovieRepository mr) {
        this.tr = tr;
        this.mr = mr;
    }

    MovieTicket bookTicket(String showId, List<ShowSeat> seats) {
        for (ShowSeat ss : seats) {
            if (ss.getStatus() != SeatStatus.VACANT) {
                throw new RuntimeException("Seat " + ss.getSeat().getId() + " is not available");
            }
            ss.setStatus(SeatStatus.IN_PROGRESS);
        }

        int totalPrice = seats.stream()
                .mapToInt(ShowSeat::getPrice)
                .sum();

        MovieTicket ticket = new MovieTicket(
                UUID.randomUUID().toString(), seats,
                seats.get(0).getShow(), null, totalPrice, BookingStatus.PENDING
        );

        // process payment (payment gateway call)

        for (ShowSeat ss : seats) {
            ss.setStatus(SeatStatus.BOOKED);
        }
        ticket.setBookingStatus(BookingStatus.CONFIRMED);

        return ticket;
    }

    List<Theatre> showTheatres(City c){
        return tr.getTheatres(c);
    }

    List<Movie> showMovies(City c){
        return mr.getMovies(c);
    }

    public List<ShowSeat> showSeatMap(String showId){
        return sr.getShow(showId).getSeats();
    }
}
