package org.example.entity;

import java.util.List;

public class Screen {
    private String id;
    private String screenName;
    private List<Show> shows;
    private List<Seat> seats;

    public Screen(String id, String screenName, List<Show> shows, List<Seat> seats) {
        this.id = id;
        this.screenName = screenName;
        this.shows = shows;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void addShow(Show s){
        this.shows.add(s);
    }
}
