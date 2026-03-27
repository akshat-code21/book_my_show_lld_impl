package org.example.service;

import org.example.entity.City;
import org.example.entity.Movie;
import org.example.entity.Screen;
import org.example.entity.Theatre;

import java.time.LocalDateTime;

public class AdminService {
    private final MovieService ms;
    private final TheatreService ts;
    private final MovieShowService mss;

    public AdminService(MovieService ms, TheatreService ts, MovieShowService mss) {
        this.ms = ms;
        this.ts = ts;
        this.mss = mss;
    }

    public void addMovie(City c, Movie m) {
        ms.addMovie(c, m);
    }

    public void addTheatre(City c, Theatre t) {
        ts.addTheatre(c, t);
    }

    public void addMovieShow(Movie m, Theatre t, Screen screen, LocalDateTime showTime) {
        mss.addMovieShow(m, t, screen, showTime);
    }
}
