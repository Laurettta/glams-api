package com.glams.service;

import com.glams.dto.request.UserRoleRequestDTO;
import com.glams.dto.response.UserRoleResponseDTO;

import java.util.List;

public interface UserRoleService {
    UserRoleResponseDTO assignRole(UserRoleRequestDTO dto);

    List<UserRoleResponseDTO> getAllUserRoles();

    UserRoleResponseDTO getUserRolesById(Long id);

    void delete(Long id);
}
