package az.hamburg.instant_goal.repository;

import az.hamburg.instant_goal.entity.PlayerStatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatisticsRepository extends JpaRepository<PlayerStatisticsEntity,Long> {
}
