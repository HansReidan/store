package com.hansreidan.store;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;

    // @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(double amount) {
        paymentService.processPayment(amount);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

}
