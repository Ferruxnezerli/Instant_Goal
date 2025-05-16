package az.hamburg.instant_goal.service.abstraction;

import az.hamburg.instant_goal.dto.request.PlayerStatisticsRequest;
import az.hamburg.instant_goal.dto.response.PlayerStatisticsResponse;

import java.util.List;

public interface PlayerStatisticsService {
    void saveStatistics(PlayerStatisticsRequest request);
    void deleteById(Long id);
    PlayerStatisticsResponse getById(Long id);
    List<PlayerStatisticsResponse> getAll(int page,int count);
    void updateById(Long id,PlayerStatisticsRequest request);
}
