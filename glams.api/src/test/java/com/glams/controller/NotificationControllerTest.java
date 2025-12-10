package com.glams.controller;

import com.glams.dto.request.NotificationRequestDTO;
import com.glams.dto.response.NotificationResponseDTO;
import com.glams.enums.NotificationStatus;
import com.glams.enums.NotificationType;
import com.glams.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class NotificationControllerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private NotificationController notificationController;

    private NotificationRequestDTO requestDTO;
    private NotificationResponseDTO responseDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        requestDTO = new NotificationRequestDTO();
        requestDTO.setUserId(1L);
        requestDTO.setMessage("Test notification");
        requestDTO.setType(NotificationType.SYSTEM_ALERT);
        requestDTO.setStatus(NotificationStatus.UNREAD);

        responseDTO = new NotificationResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setUserId(1L);
        responseDTO.setMessage("Test notification");
        responseDTO.setType(NotificationType.SYSTEM_ALERT);
        responseDTO.setStatus(NotificationStatus.UNREAD);
    }

    @Test
    void testCreate() {
        when(notificationService.create(requestDTO)).thenReturn(responseDTO);

        ResponseEntity<NotificationResponseDTO> response = notificationController.create(requestDTO);

        assertThat(response.getBody()).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(notificationService, times(1)).create(requestDTO);
    }

    @Test
    void testGetById() {
        when(notificationService.getById(1L)).thenReturn(responseDTO);

        ResponseEntity<NotificationResponseDTO> response = notificationController.getById(1L);

        assertThat(response.getBody()).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(notificationService, times(1)).getById(1L);
    }

    @Test
    void testGetAll() {
        when(notificationService.getAll()).thenReturn(List.of(responseDTO));

        ResponseEntity<List<NotificationResponseDTO>> response = notificationController.getAll();

        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody().get(0)).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(notificationService, times(1)).getAll();
    }

    @Test
    void testDelete() {
        doNothing().when(notificationService).delete(1L);

        ResponseEntity<Void> response = notificationController.delete(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(204);
        verify(notificationService, times(1)).delete(1L);
    }
}
