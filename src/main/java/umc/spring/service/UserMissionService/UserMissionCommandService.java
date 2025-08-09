package umc.spring.service.UserMissionService;

import umc.spring.domain.User;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UserMissionRequestDTO;

public interface UserMissionCommandService {
    UserMission createUserMission (UserMissionRequestDTO.UserMissionCreateDTO request, User user);

}
