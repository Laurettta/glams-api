package com.glams.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "invoice_items")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @Column(name = "item_name", nullable = false)
    private String ItemName;


    private int price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "total_price", precision = 19, scale = 2)
    private int totalPrice;

//    @PrePersist
//    @PreUpdate
//    public void calculateTotalPrice() {
//        this.totalPrice = pricePerItem * quantity;
//    }

}
