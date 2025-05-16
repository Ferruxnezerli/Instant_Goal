package az.hamburg.instant_goal.dto.response;

import az.hamburg.instant_goal.enums.ManagerStatus;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerResponse {
    Long id;
    String fullName;
    byte age;
    int numberOfCups;
    ManagerStatus status;

}
