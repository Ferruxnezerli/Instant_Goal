package az.hamburg.instant_goal.repository;

import az.hamburg.instant_goal.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<UserEntity,Long> {


   UserEntity findUserByUserName(String userName);
   boolean existsByUserName(String userName);
}
