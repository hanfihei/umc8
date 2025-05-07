package umc.spring.study.repository.ReviewRepository;

public interface ReviewRepositoryCustom {
    void insertReview(String content, int star, Long userId, Long storeId);
}
