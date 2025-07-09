package com.example.customer.controller;

import com.example.customer.dto.request.CustomerChangePasswordRequest;
import com.example.customer.dto.response.CustomerChangePasswordResponse;
import com.example.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/change-password")
    public ResponseEntity<CustomerChangePasswordResponse> changePassword(@RequestBody CustomerChangePasswordRequest request) {
        return ResponseEntity.ok(customerService.changePassword(request));
    }
}
