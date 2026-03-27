package org.example.service;

import org.example.entity.*;
import org.example.enums.SeatStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MovieShowService {
    public void addMovieShow(Movie m, Theatre t, Screen screen, LocalDateTime showTime){
        List<ShowSeat> showSeats = new ArrayList<>();
        for (Seat seat : screen.getSeats()) {
            showSeats.add(new ShowSeat(null, seat, 0, SeatStatus.VACANT));
        }
        Show show = new Show(UUID.randomUUID().toString(), showTime, m, showSeats, screen);
        screen.addShow(show);
    }
}
