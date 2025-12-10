package com.glams.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.glams.dto.request.ReviewRequestDTO;
import com.glams.dto.response.ReviewResponseDTO;
import com.glams.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReviewController.class)
class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // This mock will be injected into the ReviewController
    @Mock
    private ReviewService reviewService;

    private ReviewRequestDTO reviewRequest;
    private ReviewResponseDTO reviewResponse;

    @BeforeEach
    void setup() {
        reviewRequest = new ReviewRequestDTO();
        reviewRequest.setUserId(1L);
        reviewRequest.setServiceId(1L);
        reviewRequest.setRating(5);
        reviewRequest.setComment("Great service!");

        reviewResponse = new ReviewResponseDTO();
        reviewResponse.setId(1L);
        reviewResponse.setUserId(1L);
        reviewResponse.setServiceId(1L);
        reviewResponse.setRating(5);
        reviewResponse.setComment("Great service!");
    }

    @Test
    void testCreateReview() throws Exception {
        Mockito.when(reviewService.createReview(any(ReviewRequestDTO.class)))
                .thenReturn(reviewResponse);

        mockMvc.perform(post("/api/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reviewRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.rating").value(5))
                .andExpect(jsonPath("$.comment").value("Great service!"));
    }

    @Test
    void testGetAllReviews() throws Exception {
        Mockito.when(reviewService.getAllReviews())
                .thenReturn(List.of(reviewResponse));

        mockMvc.perform(get("/api/reviews")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L));
    }

    @Test
    void testGetReviewById() throws Exception {
        Mockito.when(reviewService.getReviewById(1L))
                .thenReturn(reviewResponse);

        mockMvc.perform(get("/api/reviews/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }
}
