package org.example.service;

import org.example.entity.Movie;
import org.example.entity.Theatre;

public class MovieShowService {
    private Movie m;
    private Theatre t;

    public MovieShowService(Movie m, Theatre t) {
        this.m = m;
        this.t = t;
    }

    public Movie getMovie() {
        return m;
    }

    public void setMovie(Movie m) {
        this.m = m;
    }

    public Theatre getTheatre() {
        return t;
    }

    public void setTheatre(Theatre t) {
        this.t = t;
    }

    public void addMovieShow(){
        
    }
}
