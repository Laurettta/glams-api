package com.glams.mapper;

import com.glams.dto.request.UserRequestDTO;
import com.glams.dto.response.UserResponseDTO;
import com.glams.enums.RoleName;
import com.glams.model.Role;
import com.glams.model.User;
import org.mapstruct.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // CREATE
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRoleNamesToRoles")
    User toEntity(UserRequestDTO dto);

    // READ
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRolesToRoleNames")
    UserResponseDTO toDTO(User user);

    // UPDATE
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRoleNamesToRoles")
    void updateUserFromDto(UserRequestDTO dto, @MappingTarget User user);

    // HELPERS
    @Named("mapRoleNamesToRoles")
    default Set<Role> mapRoleNamesToRoles(Set<RoleName> roleNames) {
        if (roleNames == null) return new HashSet<>();
        return roleNames.stream()
                .map(roleName -> Role.builder().name(roleName).build())
                .collect(Collectors.toSet());
    }

    @Named("mapRolesToRoleNames")
    default Set<RoleName> mapRolesToRoleNames(Set<Role> roles) {
        if (roles == null) return new HashSet<>();
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
