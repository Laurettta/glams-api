package com.glams.controller;

import com.glams.dto.request.LoginRequest;
import com.glams.dto.request.SignupRequest;
import com.glams.dto.response.AuthResponse;
import com.glams.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegister() {

        SignupRequest request = new SignupRequest();
        request.setEmail("test");
        request.setPassword("password");
        request.setFullName("Lauretta User");
        request.setPhoneNumber("1234657890");

        when(authService.register(request)).thenReturn("fake-jwt-token");

        ResponseEntity<AuthResponse> response = authController.register(request);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("fake-jwt-token", response.getBody().getToken());
    }

    @Test
    void login() {
        LoginRequest request = new LoginRequest();
        request.setEmail("test");
        request.setPassword("password");

        when(authService.login(request)).thenReturn("fake-jwt-token");

        ResponseEntity<AuthResponse> response = authController.login(request);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("fake-jwt-token", response.getBody().getToken());
    }
}