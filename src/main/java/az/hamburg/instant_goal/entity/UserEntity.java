package az.hamburg.instant_goal.entity;

import az.hamburg.instant_goal.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "users")
@Builder
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    @NotBlank(message = "name can't be blank")
    @Column(nullable = false, unique = true)
    String userName;

    String password;

    @Enumerated(STRING)
    UserStatus userStatus;

}
