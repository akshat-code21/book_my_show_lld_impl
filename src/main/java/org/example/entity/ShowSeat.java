package org.example.entity;

import org.example.enums.SeatStatus;

public class ShowSeat {
    private Show show;
    private Seat seat;
    private int price;
    private SeatStatus status;

    public ShowSeat(Show show, Seat seat, int price, SeatStatus status) {
        this.show = show;
        this.seat = seat;
        this.price = price;
        this.status = status;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
