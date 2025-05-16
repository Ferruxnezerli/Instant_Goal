package az.hamburg.instant_goal.service.abstraction;

import az.hamburg.instant_goal.dto.request.MatchStatisticsRequest;
import az.hamburg.instant_goal.dto.response.MatchStatisticsResponse;
import az.hamburg.instant_goal.enums.MatchStatisticsStatus;

import java.util.List;

public interface MatchStatisticsService {
    void saveStatistics(MatchStatisticsRequest request);
    void deleteById(Long id);
    MatchStatisticsResponse getById(Long id);
    List<MatchStatisticsResponse> getAll(int page,int count);
    void updateById(Long id,MatchStatisticsRequest request);
}
