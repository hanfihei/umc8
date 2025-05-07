package umc.spring.study.repository.UserRepository;

import umc.spring.study.domain.User;

public interface UserRepositoryCustom {
    User getMyPage(Long userId);
}
