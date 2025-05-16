package az.hamburg.instant_goal.entity;

import az.hamburg.instant_goal.enums.TeamStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import jakarta.validation.constraints.NotBlank;

import lombok.experimental.FieldDefaults;

import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "teams")
@Builder
@Entity
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    @NotBlank(message = "This field must not be blank")
    @Column(name = "team_name")
    String name;

    int foundYear;

    int numberOfCups;

    @Enumerated(STRING)
    TeamStatus status;

    @OneToMany(mappedBy = "homeTeam", fetch = LAZY)
    List<MatchEntity> homeMatches;

    @OneToMany(mappedBy = "awayTeam", fetch = LAZY)
    List<MatchEntity> awayMatches;

    @OneToMany(mappedBy = "team", fetch = LAZY)
    List<PlayerEntity> players;

    @OneToOne(mappedBy = "team", fetch = EAGER)
    ManagerEntity manager;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "league_id")
    LeagueEntity league;

    @OneToOne(mappedBy = "team", fetch = LAZY)
    StadiumEntity stadium;
}
