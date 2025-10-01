package com.hansreidan.store.payroll.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Order id not found: " + id);
    }
}
