package com.glams.mapper;

import com.glams.dto.request.InvoiceRequestDTO;
import com.glams.dto.response.InvoiceResponseDTO;
import com.glams.model.Booking;
import com.glams.model.Invoice;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-10T01:02:48+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public Invoice toEntity(InvoiceRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Invoice.InvoiceBuilder invoice = Invoice.builder();

        invoice.booking( invoiceRequestDTOToBooking( dto ) );
        invoice.invoiceNumber( dto.getInvoiceNumber() );
        invoice.totalAmount( dto.getTotalAmount() );
        invoice.issuedDate( dto.getIssuedDate() );
        invoice.status( dto.getStatus() );

        return invoice.build();
    }

    @Override
    public InvoiceResponseDTO toDto(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        InvoiceResponseDTO invoiceResponseDTO = new InvoiceResponseDTO();

        invoiceResponseDTO.setBookingId( invoiceBookingId( invoice ) );
        invoiceResponseDTO.setId( invoice.getId() );
        invoiceResponseDTO.setInvoiceNumber( invoice.getInvoiceNumber() );
        invoiceResponseDTO.setTotalAmount( invoice.getTotalAmount() );
        invoiceResponseDTO.setIssuedDate( invoice.getIssuedDate() );
        invoiceResponseDTO.setStatus( invoice.getStatus() );

        return invoiceResponseDTO;
    }

    @Override
    public void updateFromDto(InvoiceRequestDTO dto, Invoice invoice) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getInvoiceNumber() != null ) {
            invoice.setInvoiceNumber( dto.getInvoiceNumber() );
        }
        invoice.setTotalAmount( dto.getTotalAmount() );
        if ( dto.getIssuedDate() != null ) {
            invoice.setIssuedDate( dto.getIssuedDate() );
        }
        if ( dto.getStatus() != null ) {
            invoice.setStatus( dto.getStatus() );
        }
    }

    protected Booking invoiceRequestDTOToBooking(InvoiceRequestDTO invoiceRequestDTO) {
        if ( invoiceRequestDTO == null ) {
            return null;
        }

        Booking.BookingBuilder booking = Booking.builder();

        booking.id( invoiceRequestDTO.getBookingId() );

        return booking.build();
    }

    private Long invoiceBookingId(Invoice invoice) {
        Booking booking = invoice.getBooking();
        if ( booking == null ) {
            return null;
        }
        return booking.getId();
    }
}
