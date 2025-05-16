package az.hamburg.instant_goal.dto.response;

import az.hamburg.instant_goal.enums.MatchStatisticsStatus;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchStatisticsResponse {
    Long id;
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
}
