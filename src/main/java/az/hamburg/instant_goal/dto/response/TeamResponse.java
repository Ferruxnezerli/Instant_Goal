package az.hamburg.instant_goal.dto.response;

import az.hamburg.instant_goal.entity.MatchEntity;
import az.hamburg.instant_goal.entity.PlayerEntity;
import az.hamburg.instant_goal.enums.TeamStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamResponse {
    Long id;
    String team_name;
    int foundYear;
    int numberOfCups;
    TeamStatus status;
    List<MatchEntity> homeMatches;
    List<MatchEntity> awayMatches;
    List<PlayerEntity> players;


}
