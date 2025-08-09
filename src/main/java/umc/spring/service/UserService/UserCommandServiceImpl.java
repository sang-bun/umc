package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.config.security.jwt.JwtTokenProvider;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserPreferConverter;
import umc.spring.domain.Category;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserPrefer;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request){

        User newUser = UserConverter.toUser(request);
        newUser.encodePassword(passwordEncoder.encode(request.getPassword()));
        List<Category> categoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferList(categoryList);

        userPreferList.forEach(userPrefer -> {userPrefer.setUser(newUser);});
        return userRepository.save(newUser);
    }

    @Override
    @Transactional
    public UserResponseDTO.LoginResultDTO loginMember(UserRequestDTO.LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), user.getPasswd())){
            throw new UserHandler(ErrorStatus.INVALID_PASSWORD);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(), null,
                Collections.singleton(() -> user.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return UserConverter.toLoginResultDTO(
                user.getId(),
                accessToken
        );
    }
}
