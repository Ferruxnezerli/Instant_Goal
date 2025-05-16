package az.hamburg.instant_goal.dto.request;

import az.hamburg.instant_goal.enums.PlayerStatus;
import az.hamburg.instant_goal.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PlayerRequest {
    String name;
    byte age;
    LocalDate birthDate;
    Integer jerseyNumber;
    Boolean isCaptain;
    Position position;
    PlayerStatus status;
    Long team_id;
    Long country_id;

}
