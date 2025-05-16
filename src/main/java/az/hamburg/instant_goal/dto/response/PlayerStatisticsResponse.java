package az.hamburg.instant_goal.dto.response;

import az.hamburg.instant_goal.entity.PlayerEntity;
import az.hamburg.instant_goal.enums.PlayerStatisticsStatus;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerStatisticsResponse {
    Long id;
    int goals;
    int assists;
    int numberOfCups;
    int numberOfRedCards;
    int numberOfYellowCards;
    int minutesPlayed;
    PlayerStatisticsStatus status;
}
