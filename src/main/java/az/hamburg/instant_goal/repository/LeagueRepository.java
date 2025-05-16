package az.hamburg.instant_goal.repository;

import az.hamburg.instant_goal.entity.LeagueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<LeagueEntity,Long> {
}
