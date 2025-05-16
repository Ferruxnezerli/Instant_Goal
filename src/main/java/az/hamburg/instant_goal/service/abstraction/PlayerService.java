package az.hamburg.instant_goal.service.abstraction;

import az.hamburg.instant_goal.dto.request.PlayerRequest;
import az.hamburg.instant_goal.dto.response.PlayerResponse;

import java.util.List;

public interface PlayerService {
    void savePlayer(PlayerRequest request);
    void deleteById(Long id);
    PlayerResponse getById(Long id);
    List<PlayerResponse> getAll(int page,int count);
    void updateById(Long id,PlayerRequest request);
}
