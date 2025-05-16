package az.hamburg.instant_goal.dto.request;

import az.hamburg.instant_goal.enums.TeamStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class TeamRequest {
    String name;
    int foundYear;
    int numberOfCups;
    TeamStatus status;
    Long league_id;
}
