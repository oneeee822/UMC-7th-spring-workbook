package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.CreateResultDTO toCreateResultDTO(Review review){

        return ReviewResponseDTO.CreateResultDTO.builder()
                .memberName(review.getMember().getName())
                .storeId(review.getStore().getId())
                .createdAt(LocalDateTime.now())
                .body(review.getBody())
                .score(review.getScore())
                .reviewImageList(review.getReviewImageList().stream()
                        .map(image -> ReviewResponseDTO.CreateResultDTO.ReviewImageDto.builder()
                                .imageUrl(image.getImageUrl())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateDto request) {

        Review review = Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();

        List<ReviewImage> reviewImages = request.getReviewImageList().stream()
                .map(dto -> ReviewImage.builder()
                        .imageUrl(dto.getImageUrl())
                        .review(review) // 연관 관계 설정
                        .build())
                .collect(Collectors.toList());

        review.getReviewImageList().addAll(reviewImages);

        return review;
    }
}
