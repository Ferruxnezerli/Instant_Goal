package az.hamburg.instant_goal.dto.request;

import az.hamburg.instant_goal.enums.Continent;
import az.hamburg.instant_goal.enums.CountryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CountryRequest {
    String name;
    CountryStatus status;
    Continent continent;
}
