package org.example.payment;

import org.example.enums.PaymentStatus;

public abstract class PaymentGateway {
    private String id;
    protected PaymentStatus paymentStatus;
    public abstract void processPayment(int amount);
}
