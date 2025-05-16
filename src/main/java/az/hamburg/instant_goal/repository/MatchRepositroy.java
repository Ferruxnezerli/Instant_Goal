package az.hamburg.instant_goal.repository;

import az.hamburg.instant_goal.entity.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MatchRepositroy extends JpaRepository<MatchEntity,Long> {
}
