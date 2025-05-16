package az.hamburg.instant_goal.service.concrete;

import az.hamburg.instant_goal.dto.request.PlayerStatisticsRequest;
import az.hamburg.instant_goal.dto.response.PlayerStatisticsResponse;
import az.hamburg.instant_goal.entity.PlayerEntity;
import az.hamburg.instant_goal.entity.PlayerStatisticsEntity;
import az.hamburg.instant_goal.enums.PlayerStatisticsStatus;
import az.hamburg.instant_goal.exception.NotFoundException;
import az.hamburg.instant_goal.mapper.PlayerStatisticsMapper;
import az.hamburg.instant_goal.repository.PlayerRepository;
import az.hamburg.instant_goal.repository.PlayerStatisticsRepository;
import az.hamburg.instant_goal.service.abstraction.PlayerStatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.instant_goal.mapper.PlayerStatisticsMapper.PLAYER_STATISTICS_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@Service
@RequiredArgsConstructor
public class PlayerStatisticsImpl implements PlayerStatisticsService {

    PlayerStatisticsRepository playerStatisticsRepository;
    PlayerRepository playerRepository;

    @Override
    public void saveStatistics(PlayerStatisticsRequest request) {
        PlayerEntity player = playerRepository.findById(request.getPlayer_id())
                .orElseThrow(() -> new NotFoundException("Player can't found!"));

        PlayerStatisticsEntity playerStatisticsEntity = PLAYER_STATISTICS_MAPPER.requestToEntity(request, player);

        playerStatisticsRepository.save(playerStatisticsEntity);
    }

    @Override
    public void deleteById(Long id) {
        PlayerStatisticsEntity statistics = getStatistics(id);
        statistics.setStatus(PlayerStatisticsStatus.INACTIVE);
        playerStatisticsRepository.save(statistics);
    }

    @Override
    public PlayerStatisticsResponse getById(Long id) {
        PlayerStatisticsEntity statistics = getStatistics(id);
        PlayerStatisticsResponse statisticsResponse = PLAYER_STATISTICS_MAPPER.entityToResponse(statistics);
        return statisticsResponse;
    }

    @Override
    public List<PlayerStatisticsResponse> getAll(int page,int count) {
        Page<PlayerStatisticsEntity> statistics = playerStatisticsRepository.findAll(PageRequest.of(page, count));
        return statistics.getContent().stream().map(statistic
                -> PLAYER_STATISTICS_MAPPER.entityToResponse(statistic)).toList();
    }

    @Override
    public void updateById(Long id, PlayerStatisticsRequest request) {
        PlayerStatisticsEntity statistics = getStatistics(id);

        PlayerEntity player = playerRepository.findById(request.getPlayer_id())
                .orElseThrow(() -> new NotFoundException("Player can not found!"));

        statistics.setGoals(request.getGoals());
        statistics.setAssists(request.getAssists());
        statistics.setMinutesPlayed(request.getMinutesPlayed());
        statistics.setNumberOfCups(request.getNumberOfCups());
        statistics.setStatus(request.getStatus());
        statistics.setNumberOfRedCards(request.getNumberOfRedCards());
        statistics.setNumberOfYellowCards(request.getNumberOfYellowCards());
        statistics.setPlayer(player);
    }

    private PlayerStatisticsEntity getStatistics(Long id) {
        PlayerStatisticsEntity playerStatisticsEntity = playerStatisticsRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Statistics can't found!"));
        return playerStatisticsEntity;
    }
}
