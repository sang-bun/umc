package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

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

    public static StoreResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission) {
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .storeName(mission.getStore().getName())
                .missionId(mission.getId())
                .missionDescription(mission.getDescription())
                .point(mission.getPoint())
                .createdAt(mission.getCreatedAt())
                .endDate(mission.getEndDate())
                .build();
    }

    public static StoreResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList) {
        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.getContent().stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .missionList(missionPreViewDTOList)
                .listSize(missionPreViewDTOList.size())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .build();

    }

    public static MissionResponseDTO.MissionPreviewDTO toMissionPreviewDTO(UserMission userMission) {
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .userMissionId(userMission.getId())
                .storeName(userMission.getMission().getStore().getName())
                .description(userMission.getMission().getDescription())
                .point(userMission.getMission().getPoint())
                .endDate(userMission.getMission().getEndDate())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<UserMission> userMissionList) {
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = userMissionList.getContent().stream()
                .map(MissionConverter::toMissionPreviewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .missionList(missionPreviewDTOList)
                .listSize(missionPreviewDTOList.size())
                .totalPage(userMissionList.getTotalPages())
                .totalElements(userMissionList.getTotalElements())
                .isFirst(userMissionList.isFirst())
                .isLast(userMissionList.isLast())
                .build();
    }
}
