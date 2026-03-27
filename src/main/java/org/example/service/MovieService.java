package org.example.service;

import org.example.entity.City;
import org.example.entity.Movie;
import org.example.repository.MovieRepository;

public class MovieService {
    private MovieRepository mr;

    public MovieService(MovieRepository mr) {
        this.mr = mr;
    }

    public void addMovie(City c, Movie m){
        mr.addMovieToRepo(c,m);
    }
}
