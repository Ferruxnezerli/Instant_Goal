package az.hamburg.instant_goal.repository;

import az.hamburg.instant_goal.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity,Long> {

}
