package com.glams.service.serviceImpl;

import com.glams.dto.request.LoginRequest;
import com.glams.dto.request.SignupRequest;
import com.glams.enums.RoleName;
import com.glams.model.Role;
import com.glams.model.User;
import com.glams.repository.RoleRepository;
import com.glams.repository.UserRepository;
import com.glams.security.JwtProvider;
import com.glams.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String login(LoginRequest dto) {
        // Authenticate user credentials
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                dto.getEmail(),
                                dto.getPassword()
                        )
                );

        // Generate JWT
        return jwtProvider.generateToken(authentication);
    }

    @Override
    public String register(SignupRequest dto) {
        // Check if email exists
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Assign default role USER
        Role userRole = roleRepository.findByName(RoleName.CLIENT)
                .orElseThrow(() -> new RuntimeException("Default role USER not found"));

        // Build new User entity
        User user = User.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .phoneNumber(dto.getPhoneNumber())
                .roles(Set.of(userRole))
                .status(com.glams.enums.AccountStatus.ACTIVE)
                .isEmailVerified(false)
                .build();

        // Save to database
        userRepository.save(user);

        // Return JWT token immediately after signup
        return jwtProvider.generateTokenWithEmail(user.getEmail());
    }
}
