package com.glams.dto.request;

import com.glams.enums.BookingStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long serviceId;

    @NotNull
    private LocalDate bookingDate;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    @Positive
    private BigDecimal totalAmount;

    @NotNull
    private BookingStatus status;
}
