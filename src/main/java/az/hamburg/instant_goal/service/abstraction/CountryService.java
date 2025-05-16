package az.hamburg.instant_goal.service.abstraction;

import az.hamburg.instant_goal.dto.request.CountryRequest;
import az.hamburg.instant_goal.dto.response.CountryResponse;

import java.util.List;

public interface CountryService {
    void saveCountry(CountryRequest request);

    void deleteById(Long id);

    CountryResponse getById(Long id);

    List<CountryResponse> getAll(int page,int count);

    void updateById(Long id, CountryRequest request);

}
