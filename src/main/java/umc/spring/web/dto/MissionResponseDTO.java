package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionResultDTO {
        private Long missionId;
        private String description;
        private Integer point;
        private LocalDate endDate;
        private Long storeId;
        private String storeName;
        private LocalDateTime createdAt;
    }
}
