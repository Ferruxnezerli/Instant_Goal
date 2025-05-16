package az.hamburg.instant_goal.dto.response;

import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.LeagueStatus;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeagueResponse {
    Long id;
    String name;
    int numberOfTeams;
    LeagueStatus status;
    List<TeamEntity> teams=new ArrayList<>();
}
