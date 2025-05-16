package az.hamburg.instant_goal.dto.response;

import az.hamburg.instant_goal.entity.LeagueEntity;
import az.hamburg.instant_goal.enums.Continent;
import az.hamburg.instant_goal.enums.CountryStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryResponse {
    Long id;
    String name;
    int rankingInFifa;
    Continent continent;
    CountryStatus status;
    List<LeagueEntity> leagues=new ArrayList<>();
}
