package umc.spring.study.service.ReviewService;

public interface ReviewQueryService {
    void insertReview(String text, double star, Long userId, Long storeId);
}