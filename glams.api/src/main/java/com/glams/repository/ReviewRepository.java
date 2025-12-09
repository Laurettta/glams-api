package com.glams.repository;

import com.glams.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByUserIdAndServiceId(Long userId, Long serviceId);
}
