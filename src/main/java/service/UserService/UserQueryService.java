package umc.spring.study.service.UserService;

import umc.spring.study.domain.User;

public interface UserQueryService {

    User getMyPage(Long userId);
}
