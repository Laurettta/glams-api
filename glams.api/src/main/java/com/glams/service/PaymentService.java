package com.glams.service;

import com.glams.dto.request.PaymentRequestDTO;
import com.glams.dto.response.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {

    PaymentResponseDTO createPayment(PaymentRequestDTO dto);

    PaymentResponseDTO getPaymentById(Long id);

    List<PaymentResponseDTO> getAllPayments();

    PaymentResponseDTO updatePayment(Long id, PaymentRequestDTO dto);

    void deletePayment(Long id);
}
