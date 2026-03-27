package org.example.service;

import org.example.entity.MovieTicket;
import org.example.entity.ShowSeat;
import org.example.enums.BookingStatus;
import org.example.enums.SeatStatus;

public class CancelTicketService {
    private RefundService rs;

    public CancelTicketService(RefundService rs) {
        this.rs = rs;
    }

    public void cancel(MovieTicket mt){
        for (ShowSeat ss : mt.getSelectedSeats()) {
            ss.setStatus(SeatStatus.VACANT);
        }
        rs.processRefund(mt);
        mt.setBookingStatus(BookingStatus.CANCELLED);
    }
}
