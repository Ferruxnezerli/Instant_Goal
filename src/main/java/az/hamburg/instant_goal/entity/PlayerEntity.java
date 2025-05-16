package az.hamburg.instant_goal.entity;

import az.hamburg.instant_goal.enums.PlayerStatus;
import az.hamburg.instant_goal.enums.Position;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.FetchType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import jakarta.validation.constraints.NotBlank;

import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "players")
@Builder
@Entity
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NotBlank(message = "This field must not be blank")
    String name;

    byte age;

    LocalDate birthDate;

    Integer jerseyNumber;

    Boolean isCaptain;

    @Enumerated(EnumType.STRING)
    Position position;

    @Enumerated(EnumType.STRING)
    PlayerStatus status;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "team_id")
    TeamEntity team;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "country_id")
    CountryEntity country;

    @OneToOne(mappedBy = "player", fetch = FetchType.EAGER)
    PlayerStatisticsEntity statistics;


}
