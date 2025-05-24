package umc.spring.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.User;
import umc.spring.study.repository.UserRepository.UserRepository;
import umc.spring.study.web.dto.MyPageDTO;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl {

    private final UserRepository userRepository;

    public MyPageDTO getMyPage(Long userId) {
        return userRepository.getMyPage(userId);
    }
}
