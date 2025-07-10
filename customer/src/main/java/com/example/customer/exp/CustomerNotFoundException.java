package com.example.customer.exp;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String string) {
        super(string);
    }
}
