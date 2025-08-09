package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStore;

public class StoreRequestDTO {

    @Getter
    public static class ReviewCreateDTO {

        @ExistStore
        private Long storeId;

        @NotNull
        private Float rating;

        @NotBlank
        private String comment;
    }

}
