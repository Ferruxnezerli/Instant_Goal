package az.hamburg.instant_goal.repository;

import az.hamburg.instant_goal.entity.StadiumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<StadiumEntity,Long> {
}
