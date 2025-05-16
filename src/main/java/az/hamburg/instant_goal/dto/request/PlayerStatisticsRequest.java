package az.hamburg.instant_goal.dto.request;

import az.hamburg.instant_goal.enums.PlayerStatisticsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PlayerStatisticsRequest {
    int goals;
    int assists;
    int numberOfCups;
    int numberOfRedCards;
    int numberOfYellowCards;
    int minutesPlayed;
    PlayerStatisticsStatus status;
    Long player_id;
}
