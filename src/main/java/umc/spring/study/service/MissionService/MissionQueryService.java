package umc.spring.study.service.MissionService;

import umc.spring.study.domain.Mission;

import java.util.List;

public interface MissionQueryService {
    List<Mission> findMissionByMissionStatus(Long memberId, Long cursor, String status);
    List<Mission> getHome(Long memberId, Long regionId, Long cursor);
}
