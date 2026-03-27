package org.example.entity;

import org.example.enums.BookingStatus;

import java.util.List;

public class MovieTicket {
    private String id;
    private List<ShowSeat> selectedSeats;
    private Show s;
    private User u;
    private int totalPrice;
    private BookingStatus bookingStatus;

    public MovieTicket(String id, List<ShowSeat> selectedSeats, Show s, User u, int totalPrice, BookingStatus bookingStatus) {
        this.id = id;
        this.selectedSeats = selectedSeats;
        this.s = s;
        this.u = u;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ShowSeat> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<ShowSeat> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public Show getS() {
        return s;
    }

    public void setS(Show s) {
        this.s = s;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
