package com.glams.controller;

import com.glams.dto.request.InvoiceItemRequestDTO;
import com.glams.dto.response.InvoiceItemResponseDTO;
import com.glams.service.InvoiceItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class InvoiceItemControllerTest {

    @Mock
    private InvoiceItemService invoiceItemService;

    @InjectMocks
    private InvoiceItemController invoiceItemController;

    private InvoiceItemRequestDTO requestDTO;
    private InvoiceItemResponseDTO responseDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        requestDTO = new InvoiceItemRequestDTO();
        requestDTO.setInvoiceId(1L);
        requestDTO.setItemName("Service A");
        requestDTO.setPrice(100);
        requestDTO.setQuantity(2);

        responseDTO = new InvoiceItemResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setInvoiceId(1L);
        responseDTO.setItemName("Service A");
        responseDTO.setPrice(100);
        responseDTO.setQuantity(2);
        responseDTO.setTotalPrice(200);
    }

    @Test
    void testCreate() {
        when(invoiceItemService.create(requestDTO)).thenReturn(responseDTO);

        ResponseEntity<InvoiceItemResponseDTO> response = invoiceItemController.create(requestDTO);

        assertThat(response.getBody()).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(invoiceItemService, times(1)).create(requestDTO);
    }

    @Test
    void testGetById() {
        when(invoiceItemService.getById(1L)).thenReturn(responseDTO);

        ResponseEntity<InvoiceItemResponseDTO> response = invoiceItemController.getById(1L);

        assertThat(response.getBody()).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(invoiceItemService, times(1)).getById(1L);
    }

    @Test
    void testGetAll() {
        when(invoiceItemService.getAll()).thenReturn(List.of(responseDTO));

        ResponseEntity<List<InvoiceItemResponseDTO>> response = invoiceItemController.getAll();

        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody().get(0)).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(invoiceItemService, times(1)).getAll();
    }

    @Test
    void testUpdate() {
        when(invoiceItemService.update(1L, requestDTO)).thenReturn(responseDTO);

        ResponseEntity<InvoiceItemResponseDTO> response = invoiceItemController.update(1L, requestDTO);

        assertThat(response.getBody()).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(invoiceItemService, times(1)).update(1L, requestDTO);
    }

    @Test
    void testDelete() {
        doNothing().when(invoiceItemService).delete(1L);

        ResponseEntity<Void> response = invoiceItemController.delete(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(204);
        verify(invoiceItemService, times(1)).delete(1L);
    }
}
