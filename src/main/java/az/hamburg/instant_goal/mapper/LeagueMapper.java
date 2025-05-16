package az.hamburg.instant_goal.mapper;

import az.hamburg.instant_goal.dto.request.LeagueRequest;
import az.hamburg.instant_goal.dto.response.LeagueResponse;
import az.hamburg.instant_goal.entity.CountryEntity;
import az.hamburg.instant_goal.entity.LeagueEntity;
import az.hamburg.instant_goal.enums.LeagueStatus;

import static az.hamburg.instant_goal.mapper.CountryMapper.COUNTRY_MAPPER;

public enum LeagueMapper {
    LEAGUE_MAPPER;

    public LeagueEntity requestToEntity(LeagueRequest request, CountryEntity country) {
        LeagueEntity build = LeagueEntity.builder()
                .name(request.getName())
                .numberOfTeams(request.getNumberOfTeams())
                .country(country)
                .status(request.getStatus())
                .build();

        return build;
    }

    public LeagueResponse entityToResponse(LeagueEntity league) {
        LeagueResponse build = LeagueResponse.builder()
                .id(league.getId())
                .name(league.getName())
                .numberOfTeams(league.getNumberOfTeams())
                .status(LeagueStatus.ACTIVE)
                .build();

        return build;
    }
}
