package com.glams.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAvailabilityRequestDTO {

    private Long serviceId;
    private LocalDate availableDate;
    private LocalTime startTime;
    private LocalTime endTime;
    @Builder.Default
    private Boolean isAvailable = true;
}
