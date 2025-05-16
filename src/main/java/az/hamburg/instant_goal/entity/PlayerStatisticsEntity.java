package az.hamburg.instant_goal.entity;

import az.hamburg.instant_goal.enums.PlayerStatisticsStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
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
@Table(name = "player_statistics")
@Builder
@Entity
public class PlayerStatisticsEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    int goals;

    int assists;

    int numberOfCups;

    int numberOfRedCards;

    int numberOfYellowCards;

    int minutesPlayed;

    @Enumerated(STRING)
    PlayerStatisticsStatus status;

    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "player_id")
    PlayerEntity player;

}
