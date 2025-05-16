package az.hamburg.instant_goal.dto.request;

import az.hamburg.instant_goal.enums.ManagerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class ManagerRequest {
    String fullName;
    byte age;
    int numberOfCups;
    ManagerStatus status;
    Long team_id;
    Long country_id;
}
