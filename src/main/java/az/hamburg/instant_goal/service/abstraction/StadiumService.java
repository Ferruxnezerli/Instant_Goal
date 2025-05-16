package az.hamburg.instant_goal.service.abstraction;

import az.hamburg.instant_goal.dto.request.StadiumRequest;
import az.hamburg.instant_goal.dto.response.StadiumResponse;

import java.util.List;

public interface StadiumService {
    void saveStadium(StadiumRequest request);
    void deleteById(Long id);
    StadiumResponse getById(Long id);
    List<StadiumResponse> getAll(int page,int count);
    void updateById(Long id,StadiumRequest request);
}
