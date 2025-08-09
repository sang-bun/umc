package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

public class MissionConvertor {

    public static MissionResponseDTO.MissionResultDTO toMissionResultDTO(Mission mission, Store store) {
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(mission.getId())
                .description(mission.getDescription())
                .point(mission.getPoint())
                .endDate(mission.getEndDate())
                .storeId(store.getId())
                .storeName(store.getName())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionCreateDTO request, Store store) {
        return Mission.builder()
                .description(request.getDescription())
                .point(request.getPoint())
                .endDate(request.getEndDate())
                .store(store)
                .build();
    }
}
