package org.example.service;

import org.example.entity.MovieTicket;

public class RefundService {
    public void processRefund(MovieTicket mt){
        System.out.println("Processing refund of ₹" + mt.getTotalPrice() + " for ticket " + mt.getId());
        System.out.println("Refund successful!");
    }
}
