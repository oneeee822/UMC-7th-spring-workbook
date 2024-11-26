package umc.spring.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.spring.validation.annotation.ExistStores;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class CreateDto {
        @ExistStores @NotNull(message = "storeId는 필수입니다.")
        private Long storeId;
        @NotNull(message = "memberId는 필수입니다.")
        private Long memberId;
        @NotBlank(message = "body는 필수입니다.")
        String body;
        @NotNull(message = "score는 필수입니다.")
        @Min(0)
        @Max(5)
        Float score;
        List<ReviewImageDto> reviewImageList;
    }

    @Getter
    @Setter
    public static class ReviewImageDto {
        private String imageUrl;
    }
}
