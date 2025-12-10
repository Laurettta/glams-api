package com.glams.dto.response;

import com.glams.enums.ReviewStatus;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDTO {

    private Long id;
    private Long userId;
    private Long serviceId;
    private Integer rating;
    private String comment;
    private ReviewStatus status;
}
