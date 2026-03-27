package org.example.service;

import org.example.entity.City;
import org.example.entity.Movie;
import org.example.repository.MovieRepository;

public class MovieService {
    private City c;
    private MovieRepository mr;

    public MovieService(MovieRepository mr) {
        this.mr = mr;
    }

    public void addMovie(){
        Movie m = new Movie();
        mr.addMovieToRepo(c,m);
    }
}
