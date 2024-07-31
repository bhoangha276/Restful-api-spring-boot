package com.example.restful_api.springbootapi.service.impl;

import com.example.restful_api.springbootapi.model.entity.User;
import com.example.restful_api.springbootapi.model.request.SignUpRequest;
import com.example.restful_api.springbootapi.model.response.InvalidJwtException;
import com.example.restful_api.springbootapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = userRepository.findByLogin(username);
        return user;
    }

    public UserDetails signUp(SignUpRequest data) throws InvalidJwtException {
        if (userRepository.findByLogin(data.login()) != null) {
            throw new InvalidJwtException("Username already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        return userRepository.save(newUser);
    }
}