package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.ReviewImage;
import umc.spring.domain.Store;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResultDTO{
        String memberName;
        Long storeId;
        LocalDateTime createdAt;
        String body;
        Float score;
        private List<ReviewImageDto> reviewImageList;

        @Getter
        @Builder
        public static class ReviewImageDto {
            private String imageUrl;
        }
    }
}
