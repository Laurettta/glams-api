package com.glams.dto.request;

import com.glams.enums.ReviewStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long serviceId;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    private String comment;

    private ReviewStatus status;
}
