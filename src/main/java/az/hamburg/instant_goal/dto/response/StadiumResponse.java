package az.hamburg.instant_goal.dto.response;

import az.hamburg.instant_goal.enums.StadiumStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StadiumResponse {
    Long id;
    String name;
    Double capacity;
    StadiumStatus status;
}
