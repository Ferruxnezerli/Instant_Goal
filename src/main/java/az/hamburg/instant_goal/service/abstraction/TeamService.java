package az.hamburg.instant_goal.service.abstraction;

import az.hamburg.instant_goal.dto.request.TeamRequest;
import az.hamburg.instant_goal.dto.response.TeamResponse;

import java.util.List;

public interface TeamService {
    void saveTeam(TeamRequest request);
    void deleteById(Long id);
    TeamResponse getById(Long id);
    List<TeamResponse> getAll(int page,int count);
    void updateById(Long id,TeamRequest request);
}
