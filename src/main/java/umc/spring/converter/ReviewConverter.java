package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.CreateResultDTO toReviewResultDTO(Review review) {
        return ReviewResponseDTO.CreateResultDTO.builder()
                .nickname(review.getUser().getNickname())
                .reviewId(review.getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewCreateDTO request, Store store, User user) {
            return Review.builder()
                    .rating(request.getRating())
                    .comment(request.getComment())
                    .store(store)
                    .user(user)
                    .build();
    }

}
