package com.glams.dto.response;

import com.glams.enums.AccountStatus;
import com.glams.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Set<RoleName> roles;
    private AccountStatus status;
    private Boolean isEmailVerified;
}
