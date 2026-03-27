package org.example.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Show {
    private String id;
    private LocalDateTime showTime;
    private Movie m;
    private List<ShowSeat> seats;
    private Screen s;

    public Show(String id, LocalDateTime showTime, Movie m, List<ShowSeat> seats, Screen s) {
        this.id = id;
        this.showTime = showTime;
        this.m = m;
        this.seats = seats;
        this.s = s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public Movie getM() {
        return m;
    }

    public void setM(Movie m) {
        this.m = m;
    }

    public List<ShowSeat> getSeats() {
        return seats;
    }

    public void setSeats(List<ShowSeat> seats) {
        this.seats = seats;
    }

    public Screen getS() {
        return s;
    }

    public void setS(Screen s) {
        this.s = s;
    }
}
