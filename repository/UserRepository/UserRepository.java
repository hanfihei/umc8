package umc.spring.study.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.study.domain.User;
import umc.spring.study.domain.enums.UserStatus;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

  //  @Query("SELECT m FROM User m WHERE m.name = :name AND m.status = :status")
   // List<User> findByNameAndStatus(@Param("name") String name, @Param("status") UserStatus status);
    }
