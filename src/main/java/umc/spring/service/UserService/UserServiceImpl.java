package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.domain.User;
import umc.spring.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    public final UserRepository userRepository;

    @Override
    public User getUser() {
        return userRepository.findById(1L).orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
