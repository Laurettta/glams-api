package com.glams.dto.response;

import com.glams.enums.BookingStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingResponseDTO {

    private Long id;
    private Long userId;
    private Long serviceId;
    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private BigDecimal totalAmount;
    private BookingStatus status;
}
