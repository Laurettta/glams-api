package com.glams.mapper;

import com.glams.dto.request.PaymentRequestDTO;
import com.glams.dto.response.PaymentResponseDTO;
import com.glams.model.Booking;
import com.glams.model.Invoice;
import com.glams.model.Payment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-10T01:02:48+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payment toEntity(PaymentRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Payment.PaymentBuilder payment = Payment.builder();

        payment.booking( paymentRequestDTOToBooking( dto ) );
        payment.invoice( paymentRequestDTOToInvoice( dto ) );
        payment.amount( dto.getAmount() );
        payment.paymentMethod( dto.getPaymentMethod() );
        payment.transactionId( dto.getTransactionId() );
        payment.status( dto.getStatus() );
        payment.paymentDate( dto.getPaymentDate() );

        return payment.build();
    }

    @Override
    public PaymentResponseDTO toDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();

        paymentResponseDTO.setBookingId( paymentBookingId( payment ) );
        paymentResponseDTO.setInvoiceId( paymentInvoiceId( payment ) );
        paymentResponseDTO.setId( payment.getId() );
        paymentResponseDTO.setAmount( payment.getAmount() );
        paymentResponseDTO.setPaymentMethod( payment.getPaymentMethod() );
        paymentResponseDTO.setTransactionId( payment.getTransactionId() );
        paymentResponseDTO.setStatus( payment.getStatus() );
        paymentResponseDTO.setPaymentDate( payment.getPaymentDate() );

        return paymentResponseDTO;
    }

    @Override
    public void updateFromDto(PaymentRequestDTO dto, Payment entity) {
        if ( dto == null ) {
            return;
        }

        entity.setAmount( dto.getAmount() );
        if ( dto.getPaymentMethod() != null ) {
            entity.setPaymentMethod( dto.getPaymentMethod() );
        }
        if ( dto.getTransactionId() != null ) {
            entity.setTransactionId( dto.getTransactionId() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
        if ( dto.getPaymentDate() != null ) {
            entity.setPaymentDate( dto.getPaymentDate() );
        }
    }

    protected Booking paymentRequestDTOToBooking(PaymentRequestDTO paymentRequestDTO) {
        if ( paymentRequestDTO == null ) {
            return null;
        }

        Booking.BookingBuilder booking = Booking.builder();

        booking.id( paymentRequestDTO.getBookingId() );

        return booking.build();
    }

    protected Invoice paymentRequestDTOToInvoice(PaymentRequestDTO paymentRequestDTO) {
        if ( paymentRequestDTO == null ) {
            return null;
        }

        Invoice.InvoiceBuilder invoice = Invoice.builder();

        invoice.id( paymentRequestDTO.getInvoiceId() );

        return invoice.build();
    }

    private Long paymentBookingId(Payment payment) {
        Booking booking = payment.getBooking();
        if ( booking == null ) {
            return null;
        }
        return booking.getId();
    }

    private Long paymentInvoiceId(Payment payment) {
        Invoice invoice = payment.getInvoice();
        if ( invoice == null ) {
            return null;
        }
        return invoice.getId();
    }
}
