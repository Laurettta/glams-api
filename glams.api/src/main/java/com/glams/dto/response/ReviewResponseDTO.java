package com.glams.dto.response;

import com.glams.enums.ReviewStatus;
import lombok.Data;

@Data
public class ReviewResponseDTO {

    private Long id;
    private Long userId;
    private Long serviceId;
    private Integer rating;
    private String comment;
    private ReviewStatus status;
}
