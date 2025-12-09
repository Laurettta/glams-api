package com.glams.controller;

import com.glams.dto.request.UserRoleRequestDTO;
import com.glams.dto.response.UserRoleResponseDTO;
import com.glams.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PostMapping
    public ResponseEntity<UserRoleResponseDTO> assignRole(@RequestBody UserRoleRequestDTO userRoleRequestDTO){
        return ResponseEntity.ok(userRoleService.assignRole(userRoleRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserRoleResponseDTO>> getAllUserRoles(){
        return ResponseEntity.ok(userRoleService.getAllUserRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRoleResponseDTO> getUserRolesById(@PathVariable Long id){
        return ResponseEntity.ok(userRoleService.getUserRolesById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        userRoleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
