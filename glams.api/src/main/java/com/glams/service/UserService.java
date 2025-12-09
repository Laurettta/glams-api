package com.glams.service;

import com.glams.dto.request.UserRequestDTO;
import com.glams.dto.response.UserResponseDTO;
import com.glams.model.User;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);
    void deleteUser(Long id);
}
