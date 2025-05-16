package az.hamburg.instant_goal.mapper;

import az.hamburg.instant_goal.dto.request.PlayerStatisticsRequest;
import az.hamburg.instant_goal.dto.response.PlayerStatisticsResponse;
import az.hamburg.instant_goal.entity.PlayerEntity;
import az.hamburg.instant_goal.entity.PlayerStatisticsEntity;
import az.hamburg.instant_goal.enums.PlayerStatisticsStatus;

public enum PlayerStatisticsMapper {
    PLAYER_STATISTICS_MAPPER;

    public PlayerStatisticsEntity requestToEntity(PlayerStatisticsRequest request,PlayerEntity player){
        PlayerStatisticsEntity build = PlayerStatisticsEntity.builder()
                .goals(request.getGoals())
                .assists(request.getAssists())
                .numberOfCups(request.getNumberOfCups())
                .numberOfRedCards(request.getNumberOfRedCards())
                .numberOfYellowCards(request.getNumberOfYellowCards())
                .minutesPlayed(request.getMinutesPlayed())
                .status(request.getStatus())
                .player(player)
                .build();

        return build;
    }

    public PlayerStatisticsResponse entityToResponse(PlayerStatisticsEntity statistics){
        PlayerStatisticsResponse build = PlayerStatisticsResponse.builder()
                .id(statistics.getId())
                .goals(statistics.getGoals())
                .assists(statistics.getAssists())
                .numberOfCups(statistics.getNumberOfCups())
                .numberOfRedCards(statistics.getNumberOfRedCards())
                .numberOfYellowCards(statistics.getNumberOfYellowCards())
                .minutesPlayed(statistics.getMinutesPlayed())
                .status(PlayerStatisticsStatus.ACTIVE)
                .build();

        return build;
    }

}
