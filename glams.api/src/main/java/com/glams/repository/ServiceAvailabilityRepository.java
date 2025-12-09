package com.glams.repository;

import com.glams.model.ServiceAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface ServiceAvailabilityRepository extends JpaRepository<ServiceAvailability, Long> {
    boolean existsByServiceIdAndAvailableDateAndStartTimeAndEndTime(
            Long serviceId, LocalDate date, LocalTime startTime, LocalTime endTime);

    Optional<ServiceAvailability> findByServiceIdAndAvailableDateAndStartTimeAndEndTime(
            Long serviceId, LocalDate date, LocalTime startTime, LocalTime endTime);
}
