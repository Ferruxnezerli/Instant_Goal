package az.hamburg.instant_goal.entity;

import az.hamburg.instant_goal.enums.Continent;
import az.hamburg.instant_goal.enums.CountryStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "countries")
@Builder
@Entity
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NotBlank(message = "This field must not be blank")
    @Column(name = "country_name")
    String name;


    byte numberOfEuroCups;

    int rankingInUEFA;

    int rankingInFIFA;

    @Enumerated(STRING)
    Continent continent;

    @Enumerated(STRING)
    CountryStatus status;

    @OneToMany(mappedBy = "country",fetch = LAZY)
    List<LeagueEntity> leagues;

}
