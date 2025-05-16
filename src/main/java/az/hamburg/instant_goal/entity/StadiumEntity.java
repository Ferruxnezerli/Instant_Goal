package az.hamburg.instant_goal.entity;

import az.hamburg.instant_goal.enums.StadiumStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
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

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
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
public class StadiumEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NotBlank(message = "This field must not be blank")
    @Column(name = "stadium_name")
    String name;

    Double capacity;

    @Enumerated(STRING)
    StadiumStatus status;

    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "team_id")
    TeamEntity team;
}
