package com.glams.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.glams.controller.AuthController;
import com.glams.dto.request.LoginRequest;
import com.glams.dto.request.SignupRequest;
import com.glams.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AuthControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthService authService;

    @BeforeEach
    void setupUser() {
        SignupRequest signup = new SignupRequest();
        signup.setEmail("integrationUser_" + System.currentTimeMillis());
        signup.setPassword("password123");
        signup.setFullName("test user");
        signup.setPhoneNumber("23456713907");
        authService.register(signup); // registers user in test DB
    }

    @Test
    void testLoginIntegration() throws Exception {
        LoginRequest request = new LoginRequest();
        request.setEmail("integrationUser");
        request.setPassword("password123");

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }
}

