package com.example.customer.service;

import com.example.customer.dto.request.CustomerChangePasswordRequest;

public interface KeycloakService {
    Object changePassword(CustomerChangePasswordRequest request);
}
