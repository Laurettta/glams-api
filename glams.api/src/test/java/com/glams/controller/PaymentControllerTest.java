package com.glams.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.glams.dto.request.PaymentRequestDTO;
import com.glams.dto.response.PaymentResponseDTO;
import com.glams.enums.PaymentMethod;
import com.glams.enums.PaymentStatus;
import com.glams.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Instant;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;


@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    private PaymentRequestDTO buildRequest() {
        PaymentRequestDTO dto = new PaymentRequestDTO();
        dto.setBookingId(1L);
        dto.setAmount(100);
        dto.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        dto.setTransactionId("TX123");
        dto.setStatus(PaymentStatus.COMPLETED);
        dto.setPaymentDate(Instant.now());
        dto.setInvoiceId(2L);
        return dto;
    }

    private PaymentResponseDTO buildResponse() {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setId(1L);
        dto.setTransactionId("TX123");
        dto.setAmount(100);
        return dto;
    }

    @Test
    void testCreatePayment() throws Exception {
        PaymentRequestDTO request = buildRequest();
        PaymentResponseDTO response = buildResponse();

        Mockito.when(paymentService.createPayment(any(PaymentRequestDTO.class)))
                .thenReturn(response);

        mockMvc.perform(post("/api/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionId").value("TX123"));
    }

    @Test
    void testUpdatePayment() throws Exception {
        PaymentRequestDTO request = buildRequest();
        PaymentResponseDTO response = buildResponse();

        Mockito.when(paymentService.updatePayment(eq(1L), any(PaymentRequestDTO.class)))
                .thenReturn(response);

        mockMvc.perform(put("/api/payment/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionId").value("TX123"));
    }


    @Test
    void testGetPaymentById() throws Exception {
        PaymentResponseDTO response = buildResponse();
        Mockito.when(paymentService.getPaymentById(1L)).thenReturn(response);

        mockMvc.perform(get("/api/payment/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void testGetAllPayments() throws Exception {
        Mockito.when(paymentService.getAllPayments()).thenReturn(List.of(buildResponse()));

        mockMvc.perform(get("/api/payment"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].transactionId").value("TX123"));
    }

//    @Test
//    void testUpdatePayment() throws Exception {
//        PaymentRequestDTO request = buildRequest();
//        PaymentResponseDTO response = buildResponse();
//
//        Mockito.when(paymentService.updatePayment(eq(1L), any(PaymentRequestDTO.class))).thenReturn(response);
//
//        mockMvc.perform(put("/api/payment/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.transactionId").value("TX123"));
//    }

    @Test
    void testDeletePayment() throws Exception {
        mockMvc.perform(delete("/api/payment/1"))
                .andExpect(status().isNoContent());

        Mockito.verify(paymentService, Mockito.times(1)).deletePayment(1L);
    }
}
