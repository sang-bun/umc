package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UserMissionRequestDTO;
import umc.spring.web.dto.UserMissionResponseDTO;

public class UserMissionConverter {

    public static UserMissionResponseDTO.UserMissionResultDTO toUserMissionResultDTO(UserMission userMission, Mission mission) {
        return UserMissionResponseDTO.UserMissionResultDTO.builder()
                .userMissionId(userMission.getId())
                .createdAt(userMission.getCreatedAt())
                .endDate(mission.getEndDate())
                .build();
    }

    public static UserMission toUserMission(UserMissionRequestDTO.UserMissionCreateDTO request, User user, Mission mission) {
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
