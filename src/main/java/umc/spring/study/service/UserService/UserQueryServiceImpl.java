package umc.spring.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.User;
import umc.spring.study.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl {

    private final UserRepository userRepository;

    public User getMyPage(Long userId) {
        return userRepository.getMyPage(userId);
    }
}
