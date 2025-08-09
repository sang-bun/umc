package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class MissionCreateDTO{
        @NotNull
        private Long storeId;

        @NotBlank
        private String description;

        @NotNull
        private Integer point;

        @NotNull
        private LocalDate endDate;
    }
}
