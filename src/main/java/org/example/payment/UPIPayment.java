package org.example.payment;

import org.example.enums.PaymentStatus;

public class UPIPayment extends PaymentGateway{
    private final String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }


    @Override
    public void processPayment(int amount) {
        System.out.println("Initiating UPI payment of ₹" + amount + " via UPI ID: " + upiId);
        System.out.println("Connecting to UPI gateway...");
        System.out.println("Payment of ₹" + amount + " successful via UPI!");
        this.paymentStatus = PaymentStatus.SUCCESSFUL;
    }
}
