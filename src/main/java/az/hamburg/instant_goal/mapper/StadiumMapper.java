package az.hamburg.instant_goal.mapper;

import az.hamburg.instant_goal.dto.request.StadiumRequest;
import az.hamburg.instant_goal.dto.response.StadiumResponse;
import az.hamburg.instant_goal.entity.StadiumEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.StadiumStatus;

import static az.hamburg.instant_goal.mapper.TeamMapper.TEAM_MAPPER;

public enum StadiumMapper {
    STADIUM_MAPPER;

    public StadiumEntity requestToEntity(StadiumRequest request, TeamEntity team){
        StadiumEntity build = StadiumEntity.builder()
                .name(request.getName())
                .capacity(request.getCapacity())
                .status(request.getStatus())
                .team(team)
                .build();

        return build;
    }

    public StadiumResponse entityToResponse(StadiumEntity stadium){
        StadiumResponse build = StadiumResponse.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .capacity(stadium.getCapacity())
                .status(StadiumStatus.ACTIVE)
                .build();

        return build;
    }
}
