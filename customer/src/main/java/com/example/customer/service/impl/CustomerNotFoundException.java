package com.example.customer.service.impl;

import jakarta.validation.constraints.NotBlank;

public class CustomerNotFoundException extends @org.jetbrains.annotations.NotNull X {
    public CustomerNotFoundException(String string, @NotBlank String username) {
    }
}
