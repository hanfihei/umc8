package umc.spring.study.service.Mission2Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.MissionHandler;
import umc.spring.study.apiPayload.exception.handler.MissionHandler2;
import umc.spring.study.apiPayload.exception.handler.UserHandler;
import umc.spring.study.converter.Mission2Converter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.User;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.repository.MissionRepository.MissionRepository;
import umc.spring.study.repository.MissionRepository2.MissionRepository2;
import umc.spring.study.repository.UserRepository.UserRepository;
import umc.spring.study.web.dto.UserRequestDTO;

@Service
@RequiredArgsConstructor
public class Mission2CommandServiceImpl implements Mission2CommandService{

    private final UserRepository userRepository;

    private final MissionRepository missionRepository;

    private final MissionRepository2 missionRepository2;

    @Override
    @Transactional
    public UserMission AddMission(UserRequestDTO.AddMissionDto request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.MISSION_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new MissionHandler2(ErrorStatus.MISSION_NOT_FOUND));

        boolean ongoing = missionRepository2
                .findByUserIdAndMissionId(user.getId(), request.getMissionId())
                .isPresent();

        if (ongoing) {
            throw new MissionHandler(ErrorStatus.MISSION_FOUND);
        }

        System.out.println("✅ user ID: " + user.getId());
        System.out.println("✅ mission: " + mission);
        System.out.println("✅ mission ID: " + (mission != null ? mission.getId() : "null"));

        UserMission userMission = Mission2Converter.toMemberMission(request, user, mission);

        return missionRepository2.save(userMission);
    }
}