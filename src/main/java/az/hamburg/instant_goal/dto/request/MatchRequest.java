package az.hamburg.instant_goal.dto.request;

import az.hamburg.instant_goal.entity.MatchStatisticsEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.MatchStatus;
import az.hamburg.instant_goal.enums.MatchType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class MatchRequest {
    LocalDate startTime;
    MatchType matchType;
    MatchStatus status;
    Long home_id;
    Long away_id;

}
