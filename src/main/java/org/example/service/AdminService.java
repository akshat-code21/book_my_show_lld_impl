package org.example.service;

import org.example.entity.*;
import org.example.enums.UserRole;

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

    public void addMovie(City c, Movie m,User caller) {
        checkAdmin(caller);
        ms.addMovie(c, m);
    }

    public void addTheatre(City c, Theatre t,User caller) {
        checkAdmin(caller);
        ts.addTheatre(c, t);
    }

    public void addMovieShow(Movie m, Theatre t, Screen screen, LocalDateTime showTime,User caller) {
        checkAdmin(caller);
        mss.addMovieShow(m, t, screen, showTime);
    }

    private void checkAdmin(User caller) {
        if (caller.getRole() != UserRole.ADMIN) {
            throw new RuntimeException("Unauthorized: admin access required");
        }
    }
}
