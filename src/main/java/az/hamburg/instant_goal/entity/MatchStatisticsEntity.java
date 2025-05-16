package az.hamburg.instant_goal.entity;

import az.hamburg.instant_goal.enums.MatchStatisticsStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "match_statistics")
@Builder
@Entity
public class MatchStatisticsEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
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

    @Enumerated(STRING)
    MatchStatisticsStatus status;

    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "match_id")
    MatchEntity match;

}
