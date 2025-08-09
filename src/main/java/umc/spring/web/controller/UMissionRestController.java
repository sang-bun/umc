package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mapping.UserMission;
import umc.spring.service.UserMissionService.UserMissionQueryService;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
public class UMissionRestController {

    private final UserMissionQueryService userMissionQueryService;

    @GetMapping("/missions")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API", description = "현재 로그인한 사용자의 진행 중인 미션을 10개 단위로 페이징하여 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "1 이상의 페이지 번호를 입력")
    })
    public ApiResponse<MissionResponseDTO.MissionPreviewListDTO> getChallengingMissions(@ValidPage @RequestParam(name = "page") Integer page){
        Long userId = 1L;
        Page<UserMission> userMissionList = userMissionQueryService.getUserMissions(userId, page-1);
        return ApiResponse.onSuccess(MissionConverter.toMissionPreviewListDTO(userMissionList));
    }
}
