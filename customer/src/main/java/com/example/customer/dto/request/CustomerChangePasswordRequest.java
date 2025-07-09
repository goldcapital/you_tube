package com.example.customer.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CustomerChangePasswordRequest(
        @NotBlank String username,
        @NotBlank String password
) {
}
