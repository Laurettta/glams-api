package com.glams.service.serviceImpl;

import com.glams.dto.request.UserRoleRequestDTO;
import com.glams.dto.response.UserRoleResponseDTO;
import com.glams.mapper.UserRoleMapper;
import com.glams.model.Role;
import com.glams.model.User;
import com.glams.model.UserRole;
import com.glams.repository.RoleRepository;
import com.glams.repository.UserRepository;
import com.glams.repository.UserRoleRepository;
import com.glams.service.UserRoleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRoleMapper mapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public UserRoleResponseDTO assignRole(UserRoleRequestDTO dto) {

        // Fetch full User and Role
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));

        // Prevent duplicate assignment
        if (userRoleRepository.existsByUserIdAndRoleId(dto.getUserId(), dto.getRoleId())) {
            throw new IllegalArgumentException("User already has this role");
        }

        // Build UserRole manually
        UserRole entity = new UserRole();
        entity.setUser(user);
        entity.setRole(role);

        // Save entity -> Hibernate automatically sets createdAt/updatedAt
        UserRole saved = userRoleRepository.save(entity);

        // Map to ResponseDTO
        return mapper.toDTO(saved);
    }

    @Override
    public List<UserRoleResponseDTO> getAllUserRoles() {
        return userRoleRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public UserRoleResponseDTO getUserRolesById(Long id) {
        UserRole entity = userRoleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserRole not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        if (!userRoleRepository.existsById(id)) {
            throw new EntityNotFoundException("UserRole not found");
        }
        userRoleRepository.deleteById(id);
    }
}
