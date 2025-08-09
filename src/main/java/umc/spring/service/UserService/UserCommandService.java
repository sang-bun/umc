package umc.spring.service.UserService;

import umc.spring.domain.User;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

public interface UserCommandService {

    User joinUser(UserRequestDTO.JoinDto request);
    UserResponseDTO.LoginResultDTO loginMember(UserRequestDTO.LoginRequestDTO request);
}
