package az.hamburg.instant_goal.repository;

import az.hamburg.instant_goal.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity,Long> {
}
