package com.glams.enums;

public enum BookingStatus {

    PENDING,      // Booking created but not confirmed
    CONFIRMED,    // Payment made / confirmed
    COMPLETED,    // Service completed
    CANCELLED,    // User or provider cancelled
    NO_SHOW       // User didn’t show up
}
