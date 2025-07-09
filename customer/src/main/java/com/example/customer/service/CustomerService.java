package com.example.customer.service;

import com.example.customer.dto.request.CustomerChangePasswordRequest;
import com.example.customer.dto.response.CustomerChangePasswordResponse;

public interface CustomerService {
    CustomerChangePasswordResponse changePassword(CustomerChangePasswordRequest request);
}
