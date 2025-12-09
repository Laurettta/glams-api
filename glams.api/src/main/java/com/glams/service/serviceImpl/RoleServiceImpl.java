package com.glams.service.serviceImpl;

import com.glams.dto.request.RoleRequestDTO;
import com.glams.dto.response.RoleResponseDTO;
import com.glams.exception.ResourceNotFoundException;
import com.glams.mapper.RoleMapper;
import com.glams.model.Role;
import com.glams.repository.RoleRepository;
import com.glams.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper mapper;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO dto) {
        Role role = mapper.toEntity(dto);
        Role saved = roleRepository.save(role);
        return mapper.toDto(saved);
    }

    @Override
    public RoleResponseDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        return mapper.toDto(role);
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void deleteRole(Long id) {
        if(!roleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Role not found");
        }
        roleRepository.deleteById(id);
    }

}
