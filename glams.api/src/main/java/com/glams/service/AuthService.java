package com.glams.service;

import com.glams.dto.request.LoginRequest;
import com.glams.dto.request.SignupRequest;

public interface AuthService {

    // Login: returns JWT token
    String login(LoginRequest loginRequest);

    // Signup: returns JWT token after registration
    String register(SignupRequest signupRequest);
}
