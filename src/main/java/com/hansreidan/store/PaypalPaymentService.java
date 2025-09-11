package com.hansreidan.store;

import org.springframework.stereotype.Service;

@Service
public class PaypalPaymentService implements PaymentService {


    @Override
    public void processPayment(double amount) {
        System.out.println("Paypal Payment");
        System.out.println("Amount: " + amount);
    }
}
