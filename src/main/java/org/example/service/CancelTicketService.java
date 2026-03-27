package org.example.service;

import org.example.entity.MovieTicket;
import org.example.enums.BookingStatus;

public class CancelTicketService {
    private RefundService rs;

    public CancelTicketService(RefundService rs) {
        this.rs = rs;
    }

    public void cancel(MovieTicket mt){
        rs.processRefund(mt);
        mt.setBookingStatus(BookingStatus.CANCELLED);
    }
}
