package az.hamburg.instant_goal.repository;

import az.hamburg.instant_goal.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity,Long> {
}
