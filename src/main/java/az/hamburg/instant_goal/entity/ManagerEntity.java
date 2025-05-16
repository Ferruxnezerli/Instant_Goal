package az.hamburg.instant_goal.entity;

import az.hamburg.instant_goal.enums.ManagerStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import jakarta.validation.constraints.NotBlank;

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
@Table(name = "managers")
@Builder
@Entity
public class ManagerEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NotBlank(message = "This field must not be blank")
    String fullName;

    byte age;

    int numberOfCups;

    @Enumerated(STRING)
    ManagerStatus status;

    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "team_id")
    TeamEntity team;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "country_id")
    CountryEntity country;



}
