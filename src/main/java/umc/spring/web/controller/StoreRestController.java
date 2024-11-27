package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/review")
    public ApiResponse<ReviewResponseDTO.CreateResultDTO> join(@ExistStores @PathVariable Long storeId,
                                                               @RequestBody @Valid ReviewRequestDTO.CreateDto request) {
        Review review = storeCommandService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(review));
    }

    @PostMapping("/{storeId}/mission")
    public ApiResponse<MissionResponseDTO.AddResultDTO> addMission(@PathVariable ("storeId") Long storeId,
                                                                   @RequestBody @Valid MissionRequestDTO.AddMissionDTO request){
        Mission mission = storeCommandService.addMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }
}
