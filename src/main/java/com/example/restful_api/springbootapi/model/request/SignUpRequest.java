package com.example.restful_api.springbootapi.model.request;

import com.example.restful_api.springbootapi.constant.UserRole;

public record SignUpRequest(
        String login,
        String password,
        UserRole role) {
}
