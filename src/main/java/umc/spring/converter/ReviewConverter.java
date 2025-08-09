package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.CreateResultDTO toReviewResultDTO(Review review) {
        return ReviewResponseDTO.CreateResultDTO.builder()
                .reviewId(review.getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewCreateDTO request, Store store) {
            return Review.builder()
                    .rating(request.getRating())
                    .comment(request.getComment())
                    .store(store)
                    .build();
    }
}
