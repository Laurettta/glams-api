package com.glams.mapper;

import com.glams.dto.request.ReviewRequestDTO;
import com.glams.dto.response.ReviewResponseDTO;
import com.glams.model.Review;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "service.id", source = "serviceId")
    Review toEntity(ReviewRequestDTO dto);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "serviceId", source = "service.id")
    ReviewResponseDTO toDto(Review review);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(ReviewRequestDTO dto, @MappingTarget Review entity);
}
