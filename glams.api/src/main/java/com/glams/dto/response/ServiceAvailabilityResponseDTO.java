package com.glams.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
public class ServiceAvailabilityResponseDTO {

    private Long id;
    private Long serviceId;
    private LocalDate availableDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Boolean isAvailable;
}
