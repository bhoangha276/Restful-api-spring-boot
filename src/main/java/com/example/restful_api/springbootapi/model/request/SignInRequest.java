package com.example.restful_api.springbootapi.model.request;

public record SignInRequest(
        String login,
        String password) {
}
