package com.glams.controller;

import com.glams.dto.request.InvoiceRequestDTO;
import com.glams.dto.response.InvoiceResponseDTO;
import com.glams.enums.InvoiceStatus;
import com.glams.service.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class InvoiceControllerTest {

    @Mock
    private InvoiceService invoiceService;

    @InjectMocks
    private InvoiceController invoiceController;

    private InvoiceRequestDTO requestDTO;
    private InvoiceResponseDTO responseDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        requestDTO = new InvoiceRequestDTO();
        requestDTO.setBookingId(1L);
        requestDTO.setInvoiceNumber("INV-001");
        requestDTO.setTotalAmount(100);
        requestDTO.setIssuedDate(LocalDate.now());
        requestDTO.setStatus(InvoiceStatus.PAID);

        responseDTO = new InvoiceResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setBookingId(1L);
        responseDTO.setInvoiceNumber("INV-001");
        responseDTO.setTotalAmount(100);
        responseDTO.setIssuedDate(LocalDate.now());
        responseDTO.setStatus(InvoiceStatus.PAID);
    }

    @Test
    void testCreate() {
        when(invoiceService.create(requestDTO)).thenReturn(responseDTO);

        ResponseEntity<InvoiceResponseDTO> response = invoiceController.create(requestDTO);

        assertThat(response.getBody()).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(invoiceService, times(1)).create(requestDTO);
    }

    @Test
    void testGetById() {
        when(invoiceService.getById(1L)).thenReturn(responseDTO);

        ResponseEntity<InvoiceResponseDTO> response = invoiceController.getById(1L);

        assertThat(response.getBody()).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(invoiceService, times(1)).getById(1L);
    }

    @Test
    void testGetAll() {
        when(invoiceService.getAll()).thenReturn(List.of(responseDTO));

        ResponseEntity<List<InvoiceResponseDTO>> response = invoiceController.getAll();

        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody().get(0)).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(invoiceService, times(1)).getAll();
    }

    @Test
    void testUpdate() {
        when(invoiceService.update(1L, requestDTO)).thenReturn(responseDTO);

        ResponseEntity<InvoiceResponseDTO> response = invoiceController.update(1L, requestDTO);

        assertThat(response.getBody()).isEqualTo(responseDTO);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(invoiceService, times(1)).update(1L, requestDTO);
    }

    @Test
    void testDelete() {
        doNothing().when(invoiceService).delete(1L);

        ResponseEntity<Void> response = invoiceController.delete(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(204);
        verify(invoiceService, times(1)).delete(1L);
    }
}
