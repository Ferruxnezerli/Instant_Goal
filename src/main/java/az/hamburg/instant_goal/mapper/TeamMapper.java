package az.hamburg.instant_goal.mapper;

import az.hamburg.instant_goal.dto.request.TeamRequest;
import az.hamburg.instant_goal.dto.response.TeamResponse;
import az.hamburg.instant_goal.entity.LeagueEntity;
import az.hamburg.instant_goal.entity.ManagerEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.TeamStatus;

import static az.hamburg.instant_goal.mapper.LeagueMapper.LEAGUE_MAPPER;
import static az.hamburg.instant_goal.mapper.ManagerMapper.MANAGER_MAPPER;

public enum TeamMapper {
    TEAM_MAPPER;

    public TeamEntity requestToEntity(TeamRequest request, LeagueEntity league){
        TeamEntity build = TeamEntity.builder()
                .name(request.getName())
                .foundYear(request.getFoundYear())
                .numberOfCups(request.getNumberOfCups())
                .status(request.getStatus())
                .league(league)
                .build();

        return build;
    }

    public TeamResponse entityToResponse(TeamEntity team){
        TeamResponse build = TeamResponse.builder()
                .id(team.getId())
                .team_name(team.getName())
                .numberOfCups(team.getNumberOfCups())
                .foundYear(team.getFoundYear())
                .status(TeamStatus.ACTIVE)
                .build();

        return build;
    }
}
