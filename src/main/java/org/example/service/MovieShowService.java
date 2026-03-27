package org.example.service;

import org.example.entity.*;
import org.example.enums.SeatStatus;
import org.example.repository.ShowRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MovieShowService {
    private final ShowRepository sr;

    public MovieShowService(ShowRepository sr) {
        this.sr = sr;
    }

    public void addMovieShow(Movie m, Theatre t, Screen screen, LocalDateTime showTime) {
        for (Show existing : screen.getShows()) {
            if (existing.getShowTime().equals(showTime)) {
                throw new RuntimeException("Screen " + screen.getScreenName()
                        + " already has a show at " + showTime);
            }
        }
        List<ShowSeat> showSeats = new ArrayList<>();
        for (Seat seat : screen.getSeats()) {
            showSeats.add(new ShowSeat(null, seat, 0, SeatStatus.VACANT));
        }
        Show show = new Show(UUID.randomUUID().toString(), showTime, m, showSeats, screen);

        for (ShowSeat ss : showSeats) {
            ss.setShow(show);
        }

        screen.addShow(show);
        sr.addShow(show);
    }
}
