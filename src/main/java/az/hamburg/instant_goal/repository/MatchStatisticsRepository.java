package az.hamburg.instant_goal.repository;

import az.hamburg.instant_goal.entity.MatchStatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface MatchStatisticsRepository extends JpaRepository<MatchStatisticsEntity,Long> {
}
