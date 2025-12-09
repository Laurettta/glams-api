package com.glams.dto.request;

import com.glams.enums.InvoiceStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InvoiceRequestDTO {

    @NotNull
    private Long bookingId;

    @NotNull
    private String invoiceNumber;

    private int totalAmount;

    @NotNull
    private LocalDate issuedDate;

    @NotNull
    private InvoiceStatus status;
}
