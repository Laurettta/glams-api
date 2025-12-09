package com.glams.service;

import com.glams.dto.request.ReviewRequestDTO;
import com.glams.dto.response.ReviewResponseDTO;

import java.util.List;

public interface ReviewService {

    ReviewResponseDTO createReview(ReviewRequestDTO dto);

    ReviewResponseDTO getReviewById(Long id);

    List<ReviewResponseDTO> getAllReviews();

    ReviewResponseDTO updateReview(Long id, ReviewRequestDTO dto);

    void deleteReview(Long id);
}
