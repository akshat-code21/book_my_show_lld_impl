package org.example.service;

import org.example.entity.MovieTicket;
import org.example.entity.ShowSeat;
import org.example.enums.BookingStatus;
import org.example.enums.SeatStatus;

public class CancelTicketService {
    private final RefundService rs;

    public CancelTicketService(RefundService rs) {
        this.rs = rs;
    }

    public void cancel(MovieTicket mt){
        if (mt.getBookingStatus() == BookingStatus.CANCELLED) {
            throw new RuntimeException("Ticket is already cancelled");
        }
        if (mt.getBookingStatus() != BookingStatus.CONFIRMED) {
            throw new RuntimeException("Only confirmed tickets can be cancelled");
        }
        for (ShowSeat ss : mt.getSelectedSeats()) {
            ss.setStatus(SeatStatus.VACANT);
        }
        rs.processRefund(mt);
        mt.setBookingStatus(BookingStatus.CANCELLED);
    }
}
