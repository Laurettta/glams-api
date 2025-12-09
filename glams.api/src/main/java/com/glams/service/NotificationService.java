package com.glams.service;

import com.glams.dto.request.NotificationRequestDTO;
import com.glams.dto.response.NotificationResponseDTO;

import java.util.List;

public interface NotificationService {

    NotificationResponseDTO create(NotificationRequestDTO dto);

    NotificationResponseDTO getById(Long id);

    List<NotificationResponseDTO> getAll();

    void delete(Long id);
}
