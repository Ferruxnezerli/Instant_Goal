package az.hamburg.instant_goal.dto.response;

import az.hamburg.instant_goal.entity.MatchStatisticsEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.MatchStatus;
import az.hamburg.instant_goal.enums.MatchType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchResponse {
    Long id;
    LocalDate startTime;
    MatchStatus matchStatus;
    MatchType matchType;

}
