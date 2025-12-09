package com.glams.service;

import com.glams.dto.request.RoleRequestDTO;
import com.glams.dto.response.RoleResponseDTO;

import java.util.List;

public interface RoleService {

    RoleResponseDTO createRole(RoleRequestDTO dto);

    RoleResponseDTO getRoleById(Long id);

    List<RoleResponseDTO> getAllRoles();

    void deleteRole(Long id);
}
