package com.glams.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class CreatedOnlyEntity {

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant createdAt;
}
