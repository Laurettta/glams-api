package com.glams.dto.response;

import com.glams.enums.PaymentMethod;
import com.glams.enums.PaymentStatus;
import lombok.Data;

import java.time.Instant;

@Data
public class PaymentResponseDTO {

    private Long id;
    private Long bookingId;
    private int amount;
    private PaymentMethod paymentMethod;
    private String transactionId;
    private PaymentStatus status;
    private Instant paymentDate;
    private Long invoiceId;
}
