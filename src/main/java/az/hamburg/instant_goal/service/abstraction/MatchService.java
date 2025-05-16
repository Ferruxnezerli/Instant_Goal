package az.hamburg.instant_goal.service.abstraction;

import az.hamburg.instant_goal.dto.request.MatchRequest;
import az.hamburg.instant_goal.dto.response.MatchResponse;

import java.util.List;

public interface MatchService {
    void saveMatch(MatchRequest request);
    void deleteById(Long id);
    MatchResponse getById(Long id);
    List<MatchResponse> getAll(int page,int count);
    void updateById(Long id,MatchRequest request);
}
