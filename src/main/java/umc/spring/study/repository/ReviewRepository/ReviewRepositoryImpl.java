package umc.spring.study.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.domain.User;

import static umc.spring.study.domain.QStore.store;
import static umc.spring.study.domain.QUser.user;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    @Override
    public void insertReview(String text, int star, Long userId, Long storeId) {
        User foundUser = queryFactory
                .selectFrom(user)
                .where(user.id.eq(userId))
                .fetchOne();

        Store foundStore = queryFactory
                .selectFrom(store)
                .where(store.id.eq(storeId))
                .fetchOne();

        Review review = Review.builder()
                .text(text)
                .star(star)
                .user(foundUser)
                .store(foundStore)
                .build();

        em.persist(review);
    }
}
