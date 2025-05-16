package az.hamburg.instant_goal.mapper;

import az.hamburg.instant_goal.dto.request.MatchRequest;
import az.hamburg.instant_goal.dto.response.MatchResponse;
import az.hamburg.instant_goal.entity.MatchEntity;
import az.hamburg.instant_goal.entity.MatchStatisticsEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.MatchStatus;

public enum MatchMapper {
    MATCH_MAPPER;

    public MatchEntity requestToentity(MatchRequest request, TeamEntity homeTeam, TeamEntity awayTeam) {
        MatchEntity build = MatchEntity.builder()
                .startTime(request.getStartTime())
                .matchType(request.getMatchType())
                .status(request.getStatus())
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .build();

        return build;

    }

    public MatchResponse entityToResponse(MatchEntity match) {
        MatchResponse build = MatchResponse.builder()
                .id(match.getId())
                .startTime(match.getStartTime())
                .matchStatus(match.getStatus())
                .matchType(match.getMatchType())
                .build();

        return build;
    }
}
