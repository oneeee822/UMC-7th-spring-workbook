package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MissionConverter {

    public static MissionResponseDTO.AddResultDTO toAddResultDTO(Mission mission) {
        return MissionResponseDTO.AddResultDTO.builder()
                .storeId(mission.getStore().getId())
                .missionId(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.AddMissionDTO request, Store store) {

        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .memberMissionList(new ArrayList<>())
                .build();
    }
}
