package umc.spring.study.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor

public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public void insertReview(String content, int star, Long memberId, Long storeId){
        reviewRepository.insertReview(content, star, memberId, storeId);
    }
}