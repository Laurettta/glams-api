package com.glams.mapper;

import com.glams.dto.request.InvoiceItemRequestDTO;
import com.glams.dto.response.InvoiceItemResponseDTO;
import com.glams.model.Invoice;
import com.glams.model.InvoiceItem;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T03:07:23+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class InvoiceItemMapperImpl implements InvoiceItemMapper {

    @Override
    public InvoiceItem toEntity(InvoiceItemRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        InvoiceItem.InvoiceItemBuilder invoiceItem = InvoiceItem.builder();

        invoiceItem.invoice( invoiceItemRequestDTOToInvoice( dto ) );
        invoiceItem.price( dto.getPrice() );
        invoiceItem.quantity( dto.getQuantity() );

        invoiceItem.totalPrice( dto.getPrice() * dto.getQuantity() );

        return invoiceItem.build();
    }

    @Override
    public InvoiceItemResponseDTO toDto(InvoiceItem entity) {
        if ( entity == null ) {
            return null;
        }

        InvoiceItemResponseDTO invoiceItemResponseDTO = new InvoiceItemResponseDTO();

        invoiceItemResponseDTO.setInvoiceId( entityInvoiceId( entity ) );
        invoiceItemResponseDTO.setId( entity.getId() );
        invoiceItemResponseDTO.setItemName( entity.getItemName() );
        invoiceItemResponseDTO.setPrice( entity.getPrice() );
        if ( entity.getQuantity() != null ) {
            invoiceItemResponseDTO.setQuantity( entity.getQuantity() );
        }
        invoiceItemResponseDTO.setTotalPrice( entity.getTotalPrice() );

        return invoiceItemResponseDTO;
    }

    @Override
    public void updateFromDto(InvoiceItemRequestDTO dto, InvoiceItem entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getItemName() != null ) {
            entity.setItemName( dto.getItemName() );
        }
        entity.setPrice( dto.getPrice() );
        entity.setQuantity( dto.getQuantity() );
    }

    protected Invoice invoiceItemRequestDTOToInvoice(InvoiceItemRequestDTO invoiceItemRequestDTO) {
        if ( invoiceItemRequestDTO == null ) {
            return null;
        }

        Invoice.InvoiceBuilder invoice = Invoice.builder();

        invoice.id( invoiceItemRequestDTO.getInvoiceId() );

        return invoice.build();
    }

    private Long entityInvoiceId(InvoiceItem invoiceItem) {
        Invoice invoice = invoiceItem.getInvoice();
        if ( invoice == null ) {
            return null;
        }
        return invoice.getId();
    }
}
