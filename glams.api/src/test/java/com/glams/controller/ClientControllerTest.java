package com.glams.controller;

import com.glams.dto.request.ClientRequestDTO;
import com.glams.dto.response.ClientResponseDTO;
import com.glams.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

public class ClientControllerTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    private ClientRequestDTO requestDTO;
    private ClientResponseDTO responseDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        requestDTO = new ClientRequestDTO();
        requestDTO.setUserId(1L);

        responseDTO = new ClientResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setUserId(1L);
    }

    @Test
    void testCreate() {
        when(clientService.create(requestDTO)).thenReturn(responseDTO);

        ResponseEntity<ClientResponseDTO> response = clientController.create(requestDTO);

        assertThat(response.getBody()).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(clientService, times(1)).create(requestDTO);
    }

    @Test
    void testGetById() {
        when(clientService.getById(1L)).thenReturn(responseDTO);

        ResponseEntity<ClientResponseDTO> response = clientController.getById(1L);

        assertThat(response.getBody()).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(clientService, times(1)).getById(1L);
    }

    @Test
    void testGetAll() {
        when(clientService.getAll()).thenReturn(List.of(responseDTO));

        ResponseEntity<List<ClientResponseDTO>> response = clientController.getAll();

        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody().get(0)).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(clientService, times(1)).getAll();
    }

    @Test
    void testUpdate() {
        when(clientService.update(1L, requestDTO)).thenReturn(responseDTO);

        ResponseEntity<ClientResponseDTO> response = clientController.update(1L, requestDTO);

        assertThat(response.getBody()).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(clientService, times(1)).update(1L, requestDTO);
    }

    @Test
    void testDelete() {
        doNothing().when(clientService).delete(1L);

        ResponseEntity<Void> response = clientController.delete(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(204);
        verify(clientService, times(1)).delete(1L);
    }
}
