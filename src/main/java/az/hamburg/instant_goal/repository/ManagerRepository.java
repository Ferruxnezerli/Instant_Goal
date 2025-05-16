package az.hamburg.instant_goal.repository;

import az.hamburg.instant_goal.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerEntity,Long> {
}
