package com.glams.dto.response;

import lombok.Data;

@Data
public class InvoiceItemResponseDTO{

    private Long id;
    private Long invoiceId;
    private String itemName;
    private int price;
    private int quantity;
    private int totalPrice;
}
