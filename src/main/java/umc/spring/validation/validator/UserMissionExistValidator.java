package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.User;
import umc.spring.service.UserMissionService.UserMissionService;
import umc.spring.service.UserService.UserService;
import umc.spring.validation.annotation.ExistUserMission;

@Component
@RequiredArgsConstructor
public class UserMissionExistValidator implements ConstraintValidator<ExistUserMission, Long> {

    private final UserService userService;
    private final UserMissionService userMissionService;

    @Override
    public void initialize(ExistUserMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext constraintValidatorContext) {
        if(missionId == null) return true;

        User user = userService.getUser();

        return !userMissionService.userChallengedMission(user.getId(), missionId);

    }
}
