package umc.spring.study.service.ReviewService;

public interface ReviewQueryService {
    void insertReview(String content, int star, Long userId, Long storeId);
}