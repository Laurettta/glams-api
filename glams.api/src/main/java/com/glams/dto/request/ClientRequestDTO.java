package com.glams.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClientRequestDTO {

    @NotNull(message = "User ID is required")
    private Long userId;
}
