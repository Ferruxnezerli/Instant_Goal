package az.hamburg.instant_goal.dto.request;

import az.hamburg.instant_goal.enums.MatchStatisticsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class MatchStatisticsRequest {
    int homeScore;
    int awayScore;
    int homeTeamYellowCards;
    int awayTeamYellowCards;
    int homeTeamRedCards;
    int awayTeamRedCards;
    int homeTeamTotalShots;
    int awayTeamTotalShots;
    int homeTeamGoalKeeperSaves;
    int awayTeamGoalKeeperSaves;
    int homeTeamCornerKicks;
    int awayTeamCornerKicks;
    int homeTeamFouls;
    int awayTeamFouls;
    int homeTeamPasses;
    int awayTeamPasses;
    int homeTeamTackles;
    int awayTeamTackles;
    MatchStatisticsStatus status;
    Long match_id;


}
