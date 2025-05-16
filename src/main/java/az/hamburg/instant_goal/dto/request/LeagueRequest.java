package az.hamburg.instant_goal.dto.request;

import az.hamburg.instant_goal.enums.LeagueStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class LeagueRequest {
    String name;
    int numberOfTeams;
    LeagueStatus status;
    Long country_id;
}
