package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class AddResultDTO{
        Long storeId;
        Long missionId;
        Integer reward;
        LocalDate deadline;
        String missionSpec;
        LocalDateTime createdAt;
    }
}
