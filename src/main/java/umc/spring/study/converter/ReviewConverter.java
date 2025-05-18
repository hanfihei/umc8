package umc.spring.study.converter;

import umc.spring.study.domain.User;
import umc.spring.study.domain.Store;
import umc.spring.study.domain.Review;
import umc.spring.study.web.dto.ReviewRequestDTO;
import umc.spring.study.web.dto.ReviewResponseDTO;
import umc.spring.study.web.dto.ReviewRequestDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.AddReviewResultDTO AddReviewResultDTO(Review review){
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.AddReviewDto request, Store store, User user){

        return Review.builder()
                .text(request.getText())
                .star(request.getStar())
                .store(store)
                .user(user)
                .build();
    }
}
