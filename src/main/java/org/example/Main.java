package org.example;

import org.example.entity.*;
import org.example.enums.SeatType;
import org.example.enums.UserRole;
import org.example.payment.UPIPayment;
import org.example.repository.MovieRepository;
import org.example.repository.ShowRepository;
import org.example.repository.TheatreRepository;
import org.example.service.*;
import org.example.strategy.DefaultPricingStrategy;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShowRepository sr = new ShowRepository();
        MovieRepository mr = new MovieRepository(new HashMap<>());
        TheatreRepository tr = new TheatreRepository(new HashMap<>());

        MovieService ms = new MovieService(mr);
        TheatreService ts = new TheatreService(tr);
        MovieShowService mss = new MovieShowService(sr);
        AdminService admin = new AdminService(ms, ts, mss);

        City bangalore = new City("1", "Bangalore");
        Movie movie = new Movie("m1", "Inception");
        Seat s1 = new Seat("s1", "A", 1, SeatType.GOLD);
        Seat s2 = new Seat("s2", "A", 2, SeatType.BASIC);
        Screen screen = new Screen("sc1", "Screen 1", new ArrayList<>(), List.of(s1, s2));
        Theatre theatre = new Theatre("t1", bangalore, List.of(screen));

        User adminUser = new User("a1",UserRole.ADMIN);

        admin.addMovie(bangalore, movie,adminUser);
        admin.addTheatre(bangalore, theatre,adminUser);
        admin.addMovieShow(movie, theatre, screen, LocalDateTime.now().plusDays(1),adminUser);

        PricingCalculatorService pricing = new PricingCalculatorService(
                List.of(new DefaultPricingStrategy())
        );
        BookingService bookingService = new BookingService(tr, mr, sr, new UPIPayment("user@upi"), pricing);

        String showId = screen.getShows().get(0).getId();
        List<ShowSeat> seatMap = bookingService.showSeatMap(showId);
        System.out.println("Available seats: " + seatMap.size());

        User user = new User("u1", UserRole.CUSTOMER);
        MovieTicket ticket = bookingService.bookTicket(showId, List.of(seatMap.get(0)), user);
        System.out.println("Booking status: " + ticket.getBookingStatus());
        System.out.println("Total price: ₹" + ticket.getTotalPrice());

        CancelTicketService cancelService = new CancelTicketService(new RefundService());
        cancelService.cancel(ticket);
        System.out.println("After cancel: " + ticket.getBookingStatus());
    }
}