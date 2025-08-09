package umc.spring.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.config.security.jwt.JwtTokenProvider;
import umc.spring.converter.UserConverter;
import umc.spring.domain.User;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.UserResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return UserConverter.toMemberInfoDTO(user);
    }
}
