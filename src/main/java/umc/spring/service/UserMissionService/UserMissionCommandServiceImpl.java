package umc.spring.service.UserMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.UserMissionRepository;
import umc.spring.web.dto.UserMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserMissionRepository userMissionRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public UserMission createUserMission (UserMissionRequestDTO.UserMissionCreateDTO request, User user){
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        UserMission userMission = UserMissionConverter.toUserMission(request, user, mission);

        return userMissionRepository.save(userMission);
    }
}
