package az.hamburg.instant_goal.entity;

import az.hamburg.instant_goal.enums.MatchStatus;
import az.hamburg.instant_goal.enums.MatchType;
import az.hamburg.instant_goal.enums.RefereeStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
@Table(name = "matches")
@Builder
@Entity
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    LocalDate startTime;

    @Enumerated(STRING)
    MatchStatus status;

    @Enumerated(STRING)
    MatchType matchType;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "home_id")
    TeamEntity homeTeam;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "away_id")
    TeamEntity awayTeam;

    @OneToOne(mappedBy = "match", fetch = EAGER)
    MatchStatisticsEntity statistics;







}
