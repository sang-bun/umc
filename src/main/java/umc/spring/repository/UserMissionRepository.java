package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByUserIdAndMissionId(Long userId, Long missionId);

    Page<UserMission> findAllByUserIdAndStatus(Long userId, MissionStatus missionStatus, PageRequest pageRequest);
}
