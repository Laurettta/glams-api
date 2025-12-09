package com.glams.dto.request;

import com.glams.enums.PaymentMethod;
import com.glams.enums.PaymentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class PaymentRequestDTO {

    @NotNull
    private Long bookingId;

    @NotNull
    private int amount;

    @NotNull
    private PaymentMethod paymentMethod;

    @NotNull
    private String transactionId;

    @NotNull
    private PaymentStatus status;

    @NotNull
    private Instant paymentDate;

    private Long invoiceId;
}
