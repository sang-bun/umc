package umc.spring.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.UserMissionRepository;

@Service
@RequiredArgsConstructor
public class UserMissionQueryServiceImpl implements UserMissionQueryService {

    private final UserMissionRepository userMissionRepository;

    @Override
    public Page<UserMission> getUserMissions(Long userId, Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        return userMissionRepository.findAllByUserIdAndStatus(userId, MissionStatus.CHALLENGING, pageRequest);
    }
}
