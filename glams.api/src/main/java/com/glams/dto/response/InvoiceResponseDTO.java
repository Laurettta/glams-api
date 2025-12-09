package com.glams.dto.response;

import com.glams.enums.InvoiceStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InvoiceResponseDTO {

    private Long id;
    private Long bookingId;
    private String invoiceNumber;
    private int totalAmount;
    private LocalDate issuedDate;
    private InvoiceStatus status;
}
