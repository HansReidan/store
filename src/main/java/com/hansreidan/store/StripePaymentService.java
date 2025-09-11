package com.hansreidan.store;

import org.springframework.stereotype.Service;

public class StripePaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("Stripe Payment");
        System.out.println("Amount: " + amount);

    }

}
