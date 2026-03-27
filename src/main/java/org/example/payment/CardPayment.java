package org.example.payment;

import org.example.enums.PaymentStatus;

public class CardPayment extends PaymentGateway{
    private final String cardNumber;
    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(int amount) {
        System.out.println("Initiating card payment of ₹" + amount);
        System.out.println("Connecting to card gateway...");
        System.out.println("Payment of ₹" + amount + " successful via card ending " + cardNumber.substring(cardNumber.length() - 4));
        this.paymentStatus = PaymentStatus.SUCCESSFUL;
    }
}
