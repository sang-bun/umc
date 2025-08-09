package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserMission;
import umc.spring.service.UserMissionService.UserMissionCommandService;
import umc.spring.service.UserService.UserService;
import umc.spring.web.dto.UserMissionRequestDTO;
import umc.spring.web.dto.UserMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("user-missions")
public class UserMissionRestController{

    private final UserMissionCommandService userMissionCommandService;
    private final UserService userService;

    @PostMapping("/")
    public ApiResponse<UserMissionResponseDTO.UserMissionResultDTO> createUserMission(@RequestBody @Valid UserMissionRequestDTO.UserMissionCreateDTO request){
        User user = userService.getUser();
        UserMission userMission = userMissionCommandService.createUserMission(request,user);
        return ApiResponse.onSuccess(UserMissionConverter.toUserMissionResultDTO(userMission, userMission.getMission()));
    }
}
