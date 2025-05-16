package az.hamburg.instant_goal.dto.request;

import az.hamburg.instant_goal.enums.StadiumStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class StadiumRequest {
    String name;
    Double capacity;
    StadiumStatus status;
    Long team_id;
}
