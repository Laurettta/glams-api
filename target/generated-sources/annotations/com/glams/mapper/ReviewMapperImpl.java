package com.glams.mapper;

import com.glams.dto.request.ReviewRequestDTO;
import com.glams.dto.response.ReviewResponseDTO;
import com.glams.model.Review;
import com.glams.model.Service;
import com.glams.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-11T16:55:20+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review toEntity(ReviewRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        review.user( reviewRequestDTOToUser( dto ) );
        review.service( reviewRequestDTOToService( dto ) );
        review.rating( dto.getRating() );
        review.comment( dto.getComment() );
        review.status( dto.getStatus() );

        return review.build();
    }

    @Override
    public ReviewResponseDTO toDto(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewResponseDTO.ReviewResponseDTOBuilder reviewResponseDTO = ReviewResponseDTO.builder();

        reviewResponseDTO.userId( reviewUserId( review ) );
        reviewResponseDTO.serviceId( reviewServiceId( review ) );
        reviewResponseDTO.id( review.getId() );
        reviewResponseDTO.rating( review.getRating() );
        reviewResponseDTO.comment( review.getComment() );
        reviewResponseDTO.status( review.getStatus() );

        return reviewResponseDTO.build();
    }

    @Override
    public void updateFromDto(ReviewRequestDTO dto, Review entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getRating() != null ) {
            entity.setRating( dto.getRating() );
        }
        if ( dto.getComment() != null ) {
            entity.setComment( dto.getComment() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
    }

    protected User reviewRequestDTOToUser(ReviewRequestDTO reviewRequestDTO) {
        if ( reviewRequestDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( reviewRequestDTO.getUserId() );

        return user.build();
    }

    protected Service reviewRequestDTOToService(ReviewRequestDTO reviewRequestDTO) {
        if ( reviewRequestDTO == null ) {
            return null;
        }

        Service.ServiceBuilder service = Service.builder();

        service.id( reviewRequestDTO.getServiceId() );

        return service.build();
    }

    private Long reviewUserId(Review review) {
        User user = review.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    private Long reviewServiceId(Review review) {
        Service service = review.getService();
        if ( service == null ) {
            return null;
        }
        return service.getId();
    }
}
