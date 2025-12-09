package com.glams.model;

import com.glams.enums.ReviewStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Table(name = "reviews",
uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "service_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(callSuper = false)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    Many reviews beloong to one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    Many reviews belong to one service
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Enumerated(EnumType.STRING)
    private ReviewStatus status; // e.g., PENDING, APPROVED, REJECTED

}
