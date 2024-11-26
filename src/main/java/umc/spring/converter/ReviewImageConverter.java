package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.web.dto.ReviewRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewImageConverter {

    public static List<ReviewImage> toReviewImageList(List<ReviewRequestDTO.ReviewImageDto> reviewImageList, Review review) {
        return reviewImageList.stream()
                .map(dto -> ReviewImage.builder()
                        .imageUrl(dto.getImageUrl()) // DTO에서 이미지 URL 추출
                        .review(review) // Review와 연관 관계 설정
                        .build())
                .collect(Collectors.toList());
    }
}
