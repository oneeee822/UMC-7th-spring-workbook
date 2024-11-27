package umc.spring.service.StoreService;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.ReviewRequestDTO;

public interface StoreCommandService {
    Review createReview(ReviewRequestDTO.CreateDto request);
    Mission addMission(MissionRequestDTO.AddMissionDTO request, Long storeId);
}
