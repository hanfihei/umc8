package umc.spring.study.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Store;
import umc.spring.study.domain.enums.MissionStatusType;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {

    boolean existsByStoreAndStatus(Store store, MissionStatusType status);

}
