package com.glams.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InvoiceItemRequestDTO {

    @NotNull
    private Long invoiceId;

    @NotNull
    private String itemName;

    @Min(0)
    private int price;

    @Min(1)
    private int quantity;
}
