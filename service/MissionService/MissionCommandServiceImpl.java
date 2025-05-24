package umc.spring.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.MissionHandler;
import umc.spring.study.converter.MissionConverter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Store;
import umc.spring.study.domain.enums.MissionStatusType;
import umc.spring.study.repository.MissionRepository.MissionRepository;
import umc.spring.study.repository.StoreRepository.StoreRepository;
import umc.spring.study.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl  implements MissionCommandService {

    private final MissionRepository missionRepository;

    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.AddMissionDto request, Long storeId) {
        Store store = storeRepository.findStoreById(storeId);

        boolean exists = missionRepository.existsByStoreAndStatus(store, MissionStatusType.ONGOING);

        if (exists) {
            // 야매: 예외 안 던지고 실패 응답 직접 반환
            throw new MissionHandler(ErrorStatus.MISSION_ALREADY_IN_PROGRESS);
            // ↓ 위가 안 되면 이걸 컨트롤러에서 대신 처리해도 됨
        }

        Mission mission = MissionConverter.toMission(request, store);
        return missionRepository.save(mission);
    }
}