package org.example.service;

import org.example.entity.*;
import org.example.repository.MovieRepository;
import org.example.repository.TheatreRepository;

import java.util.List;

public class BookingService {
    private TheatreRepository tr;
    private MovieRepository mr;

    public BookingService(TheatreRepository tr, MovieRepository mr) {
        this.tr = tr;
        this.mr = mr;
    }

    MovieTicket bookTicket(String showId, List<ShowSeat> seats){

    }

    List<Theatre> showTheatres(City c){
        return tr.getTheatres(c);
    }

    List<Movie> showMovies(City c){
        return mr.getMovies(c);
    }

    public void showSeatMap(String showId){

    }
}
