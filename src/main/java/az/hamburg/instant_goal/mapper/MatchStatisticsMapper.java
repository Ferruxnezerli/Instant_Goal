package az.hamburg.instant_goal.mapper;

import az.hamburg.instant_goal.dto.request.MatchStatisticsRequest;
import az.hamburg.instant_goal.dto.response.MatchStatisticsResponse;
import az.hamburg.instant_goal.entity.MatchEntity;
import az.hamburg.instant_goal.entity.MatchStatisticsEntity;
import az.hamburg.instant_goal.enums.MatchStatisticsStatus;

public enum MatchStatisticsMapper {
    MATCH_STATISTICS_MAPPER;

    public MatchStatisticsEntity requestToEntity(MatchStatisticsRequest request, MatchEntity match){
        MatchStatisticsEntity build = MatchStatisticsEntity.builder()
                .homeScore(request.getHomeScore())
                .awayScore(request.getAwayScore())
                .homeTeamYellowCards(request.getHomeTeamYellowCards())
                .homeTeamRedCards(request.getHomeTeamRedCards())
                .awayTeamYellowCards(request.getAwayTeamYellowCards())
                .awayTeamRedCards(request.getAwayTeamRedCards())
                .homeTeamTotalShots(request.getHomeTeamTotalShots())
                .awayTeamTotalShots(request.getAwayTeamTotalShots())
                .homeTeamGoalKeeperSaves(request.getHomeTeamGoalKeeperSaves())
                .awayTeamGoalKeeperSaves(request.getAwayTeamGoalKeeperSaves())
                .homeTeamCornerKicks(request.getHomeTeamCornerKicks())
                .awayTeamCornerKicks(request.getAwayTeamCornerKicks())
                .homeTeamFouls(request.getHomeTeamFouls())
                .awayTeamFouls(request.getAwayTeamFouls())
                .homeTeamPasses(request.getHomeTeamPasses())
                .awayTeamPasses(request.getAwayTeamPasses())
                .homeTeamTackles(request.getHomeTeamTackles())
                .awayTeamTackles(request.getAwayTeamTackles())
                .match(match)
                .status(request.getStatus())
                .build();
        return build;
    }

    public MatchStatisticsResponse entityToResponse(MatchStatisticsEntity entity){
        MatchStatisticsResponse build = MatchStatisticsResponse.builder()
                .id(entity.getId())
                .homeScore(entity.getHomeScore())
                .awayScore(entity.getAwayScore())
                .homeTeamYellowCards(entity.getHomeTeamYellowCards())
                .homeTeamRedCards(entity.getHomeTeamRedCards())
                .awayTeamYellowCards(entity.getAwayTeamYellowCards())
                .awayTeamRedCards(entity.getAwayTeamRedCards())
                .homeTeamTotalShots(entity.getHomeTeamTotalShots())
                .awayTeamTotalShots(entity.getAwayTeamTotalShots())
                .homeTeamGoalKeeperSaves(entity.getHomeTeamGoalKeeperSaves())
                .awayTeamGoalKeeperSaves(entity.getAwayTeamGoalKeeperSaves())
                .homeTeamCornerKicks(entity.getHomeTeamCornerKicks())
                .awayTeamCornerKicks(entity.getAwayTeamCornerKicks())
                .homeTeamFouls(entity.getHomeTeamFouls())
                .awayTeamFouls(entity.getAwayTeamFouls())
                .homeTeamPasses(entity.getHomeTeamPasses())
                .awayTeamPasses(entity.getAwayTeamPasses())
                .homeTeamTackles(entity.getHomeTeamTackles())
                .awayTeamTackles(entity.getAwayTeamTackles())
                .status(MatchStatisticsStatus.ACTIVE)
                .build();

        return build;
    }

}
