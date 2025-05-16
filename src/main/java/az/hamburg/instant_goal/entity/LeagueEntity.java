package az.hamburg.instant_goal.entity;

import az.hamburg.instant_goal.enums.LeagueStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "leagues")
@Builder
@Entity
public class LeagueEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NotBlank(message = "This field must not be blank")
    String name;

    int numberOfTeams;

    @Enumerated(STRING)
    LeagueStatus status;

    @OneToMany(mappedBy = "league", fetch = LAZY)
    List<TeamEntity> teams;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "country_id")
    CountryEntity country;

}
