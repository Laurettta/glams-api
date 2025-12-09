package com.glams.mapper;

import com.glams.dto.request.BookingRequestDTO;
import com.glams.dto.response.BookingResponseDTO;
import com.glams.model.Booking;
import com.glams.model.Service;
import com.glams.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T03:07:23+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public Booking toEntity(BookingRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Booking.BookingBuilder booking = Booking.builder();

        booking.user( bookingRequestDTOToUser( dto ) );
        booking.service( bookingRequestDTOToService( dto ) );
        booking.bookingDate( dto.getBookingDate() );
        booking.startTime( dto.getStartTime() );
        booking.endTime( dto.getEndTime() );
        booking.totalAmount( dto.getTotalAmount() );
        booking.status( dto.getStatus() );

        return booking.build();
    }

    @Override
    public BookingResponseDTO toDto(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();

        bookingResponseDTO.setUserId( bookingUserId( booking ) );
        bookingResponseDTO.setServiceId( bookingServiceId( booking ) );
        bookingResponseDTO.setId( booking.getId() );
        bookingResponseDTO.setBookingDate( booking.getBookingDate() );
        bookingResponseDTO.setStartTime( booking.getStartTime() );
        bookingResponseDTO.setEndTime( booking.getEndTime() );
        bookingResponseDTO.setTotalAmount( booking.getTotalAmount() );
        bookingResponseDTO.setStatus( booking.getStatus() );

        return bookingResponseDTO;
    }

    @Override
    public void updateFromDto(BookingRequestDTO dto, Booking booking) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getBookingDate() != null ) {
            booking.setBookingDate( dto.getBookingDate() );
        }
        if ( dto.getStartTime() != null ) {
            booking.setStartTime( dto.getStartTime() );
        }
        if ( dto.getEndTime() != null ) {
            booking.setEndTime( dto.getEndTime() );
        }
        if ( dto.getTotalAmount() != null ) {
            booking.setTotalAmount( dto.getTotalAmount() );
        }
        if ( dto.getStatus() != null ) {
            booking.setStatus( dto.getStatus() );
        }
    }

    protected User bookingRequestDTOToUser(BookingRequestDTO bookingRequestDTO) {
        if ( bookingRequestDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( bookingRequestDTO.getUserId() );

        return user.build();
    }

    protected Service bookingRequestDTOToService(BookingRequestDTO bookingRequestDTO) {
        if ( bookingRequestDTO == null ) {
            return null;
        }

        Service.ServiceBuilder service = Service.builder();

        service.id( bookingRequestDTO.getServiceId() );

        return service.build();
    }

    private Long bookingUserId(Booking booking) {
        User user = booking.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    private Long bookingServiceId(Booking booking) {
        Service service = booking.getService();
        if ( service == null ) {
            return null;
        }
        return service.getId();
    }
}
