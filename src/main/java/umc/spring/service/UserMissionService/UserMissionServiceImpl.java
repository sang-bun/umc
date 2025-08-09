package umc.spring.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.UserMissionRepository;

@Service
@RequiredArgsConstructor
public class UserMissionServiceImpl implements UserMissionService {

    public final UserMissionRepository userMissionRepository;

    @Override
    public boolean userChallengedMission(Long userId, Long missionId) {
        return userMissionRepository.existsByUserIdAndMissionId(userId, missionId);
    }


}
