package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistUserMission;

public class UserMissionRequestDTO {

    @Getter
    public static class UserMissionCreateDTO {

        @NotNull
        @ExistUserMission
        private Long missionId;
    }
}
