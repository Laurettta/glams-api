package com.glams.dto.request;

import com.glams.enums.AccountStatus;
import com.glams.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDTO {
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    @Builder.Default
    private Set<RoleName> roles = new HashSet<>();
    private AccountStatus status;
}
