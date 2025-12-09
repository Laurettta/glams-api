package com.glams.service.serviceImpl;

import com.glams.dto.request.SignupRequest;
import com.glams.enums.AccountStatus;
import com.glams.enums.RoleName;
import com.glams.model.Role;
import com.glams.model.User;
import com.glams.repository.RoleRepository;
import com.glams.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceRegistration {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public void registerUser(SignupRequest dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already taken");
        }

        User user = User.builder()
                .email(dto.getEmail())
                .fullName(dto.getFullName())
                .password(passwordEncoder.encode(dto.getPassword())) // hashing
                .phoneNumber(dto.getPhoneNumber())
                .status(AccountStatus.ACTIVE)
                .isEmailVerified(false)
                .build();

        Role defaultRole = roleRepository.findByName(RoleName.CLIENT)
                .orElseThrow(() -> new RuntimeException("Default role not found"));

        user.setRoles(Set.of(defaultRole));

        userRepository.save(user);
    }
}
