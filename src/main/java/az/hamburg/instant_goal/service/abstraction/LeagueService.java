package az.hamburg.instant_goal.service.abstraction;

import az.hamburg.instant_goal.dto.request.LeagueRequest;
import az.hamburg.instant_goal.dto.response.LeagueResponse;

import java.util.List;

public interface LeagueService {
    void saveLeague(LeagueRequest request);
    void deleteById(Long id);
    LeagueResponse getById(Long id);
    List<LeagueResponse> getAll(int page,int count);
    void updateById(Long id,LeagueRequest request);
}
