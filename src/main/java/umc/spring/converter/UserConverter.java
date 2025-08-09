package umc.spring.converter;

import umc.spring.domain.User;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request) {

        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .passwd(request.getPassword())
                .gender(request.getGender())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .role(request.getRole())
                .userPreferList(new ArrayList<>())
                .build();
    }

    public static UserResponseDTO.LoginResultDTO toLoginResultDTO(Long memberId, String accessToken) {
        return UserResponseDTO.LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static UserResponseDTO.MemberInfoDTO toMemberInfoDTO(User user){
        return UserResponseDTO.MemberInfoDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender().name())
                .build();
    }

}
