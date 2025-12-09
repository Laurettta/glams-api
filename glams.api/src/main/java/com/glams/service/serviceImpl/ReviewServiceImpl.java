package com.glams.service.serviceImpl;

import com.glams.dto.request.ReviewRequestDTO;
import com.glams.dto.response.ReviewResponseDTO;
import com.glams.exception.ResourceNotFoundException;
import com.glams.mapper.ReviewMapper;
import com.glams.model.Review;
import com.glams.model.Service;
import com.glams.model.User;
import com.glams.repository.ReviewRepository;
import com.glams.repository.ServiceRepository;
import com.glams.repository.UserRepository;
import com.glams.service.ReviewService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;
    private final ReviewMapper mapper;

    @Override
    public ReviewResponseDTO createReview(ReviewRequestDTO dto) {
        // check if user exists
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // check if service exists
        Service service = serviceRepository.findById(dto.getServiceId())
                .orElseThrow(() -> new ResourceNotFoundException("Service not found"));

        // check unique review
        reviewRepository.findByUserIdAndServiceId(dto.getUserId(), dto.getServiceId())
                .ifPresent(r -> { throw new EntityExistsException("User has already reviewed this service"); });

        Review review = mapper.toEntity(dto);
        review.setUser(user);
        review.setService(service);

        return mapper.toDto(reviewRepository.save(review));
    }

    @Override
    public ReviewResponseDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found"));
        return mapper.toDto(review);
    }

    @Override
    public List<ReviewResponseDTO> getAllReviews() {
        return reviewRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ReviewResponseDTO updateReview(Long id, ReviewRequestDTO dto) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found"));
        mapper.updateFromDto(dto, review);
        return mapper.toDto(reviewRepository.save(review));
    }

    @Override
    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new ResourceNotFoundException("Review not found");
        }
        reviewRepository.deleteById(id);
    }
}
