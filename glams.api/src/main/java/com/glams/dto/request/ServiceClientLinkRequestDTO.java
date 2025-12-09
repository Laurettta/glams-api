package com.glams.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceClientLinkRequestDTO {

    private Long ClientId;
    private Long serviceProviderId;
}
