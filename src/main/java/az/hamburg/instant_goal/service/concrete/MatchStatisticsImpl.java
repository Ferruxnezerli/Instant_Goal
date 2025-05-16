package az.hamburg.instant_goal.service.concrete;

import az.hamburg.instant_goal.dto.request.MatchStatisticsRequest;
import az.hamburg.instant_goal.dto.response.MatchStatisticsResponse;
import az.hamburg.instant_goal.entity.MatchEntity;
import az.hamburg.instant_goal.entity.MatchStatisticsEntity;
import az.hamburg.instant_goal.enums.MatchStatisticsStatus;
import az.hamburg.instant_goal.exception.NotFoundException;
import az.hamburg.instant_goal.mapper.MatchStatisticsMapper;
import az.hamburg.instant_goal.repository.MatchRepositroy;
import az.hamburg.instant_goal.repository.MatchStatisticsRepository;
import az.hamburg.instant_goal.service.abstraction.MatchStatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.instant_goal.mapper.MatchStatisticsMapper.MATCH_STATISTICS_MAPPER;
import static az.hamburg.instant_goal.mapper.MatchStatisticsMapper.values;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@Service
@RequiredArgsConstructor
public class MatchStatisticsImpl implements MatchStatisticsService {

    MatchStatisticsRepository repository;
    MatchRepositroy matchRepositroy;


    @Override
    public void saveStatistics(MatchStatisticsRequest request) {
        MatchEntity match = matchRepositroy.findById(request.getMatch_id())
                .orElseThrow(() -> new NotFoundException("Match can't found!"));

        MatchStatisticsEntity statistics = MATCH_STATISTICS_MAPPER.requestToEntity(request,match);
        repository.save(statistics);
    }

    @Override
    public void deleteById(Long id) {
        MatchStatisticsEntity statistics = getStatistics(id);
        statistics.setStatus(MatchStatisticsStatus.PASSIVE);
        repository.save(statistics);
    }

    @Override
    public MatchStatisticsResponse getById(Long id) {
        MatchStatisticsEntity statistics = getStatistics(id);
        MatchStatisticsResponse response = MATCH_STATISTICS_MAPPER.entityToResponse(statistics);
        return response;
    }

    @Override
    public List<MatchStatisticsResponse> getAll(int page,int count) {
        Page<MatchStatisticsEntity> statistics = repository.findAll(PageRequest.of(page, count));
       return   statistics.getContent().stream()
                .map(statistic
                        -> MATCH_STATISTICS_MAPPER.entityToResponse(statistic)).toList();
    }

    @Override
    public void updateById(Long id, MatchStatisticsRequest request) {
        MatchStatisticsEntity statistics = getStatistics(id);

        MatchEntity match = matchRepositroy.findById(id)
                .orElseThrow(() -> new NotFoundException("Match can't found!"));

        statistics.setAwayScore(request.getAwayScore());
        statistics.setHomeTeamYellowCards(request.getHomeTeamYellowCards());
        statistics.setHomeTeamRedCards(request.getHomeTeamRedCards());
        statistics.setAwayTeamYellowCards(request.getAwayTeamYellowCards());
        statistics.setAwayTeamRedCards(request.getAwayTeamRedCards());
        statistics.setHomeTeamTotalShots(request.getHomeTeamTotalShots());
        statistics.setAwayTeamTotalShots(request.getAwayTeamTotalShots());
        statistics.setHomeTeamGoalKeeperSaves(request.getHomeTeamGoalKeeperSaves());
        statistics.setAwayTeamGoalKeeperSaves(request.getAwayTeamGoalKeeperSaves());
        statistics.setHomeTeamCornerKicks(request.getHomeTeamCornerKicks());
        statistics.setAwayTeamCornerKicks(request.getAwayTeamCornerKicks());
        statistics.setHomeTeamFouls(request.getHomeTeamFouls());
        statistics.setAwayTeamFouls(request.getAwayTeamFouls());
        statistics.setHomeTeamPasses(request.getHomeTeamPasses());
        statistics.setAwayTeamPasses(request.getAwayTeamPasses());
        statistics.setHomeTeamTackles(request.getHomeTeamTackles());
        statistics.setAwayTeamTackles(request.getAwayTeamTackles());
        statistics.setMatch(match);

        repository.save(statistics);
    }

    private MatchStatisticsEntity getStatistics(Long id) {
        MatchStatisticsEntity statistics = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Statistics can't found!"));
        return statistics;
    }
}
