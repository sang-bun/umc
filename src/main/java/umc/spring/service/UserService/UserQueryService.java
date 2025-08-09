package umc.spring.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import umc.spring.web.dto.UserResponseDTO;

public interface UserQueryService {
    UserResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
