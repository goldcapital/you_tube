package com.example.customer.service.impl;

import com.example.customer.dto.request.CustomerChangePasswordRequest;
import com.example.customer.dto.response.CustomerChangePasswordResponse;
import com.example.customer.service.CustomerService;
import com.example.customer.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private  final KeycloakService keycloakService;
    @Override
    public CustomerChangePasswordResponse changePassword(CustomerChangePasswordRequest request) {
        var response =keycloakService.changePassword(request);
        return null;
    }
}
