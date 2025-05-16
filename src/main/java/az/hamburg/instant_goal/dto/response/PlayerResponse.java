package az.hamburg.instant_goal.dto.response;

import az.hamburg.instant_goal.enums.PlayerStatus;
import az.hamburg.instant_goal.enums.Position;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerResponse {
    Long id;
    String name;
    byte age;
    LocalDate birthDate;
    Integer jerseyNumber;
    Boolean isCaptain;
    Position position;
    PlayerStatus status;

}
