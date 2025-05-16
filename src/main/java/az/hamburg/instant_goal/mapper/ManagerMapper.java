package az.hamburg.instant_goal.mapper;

import az.hamburg.instant_goal.dto.request.ManagerRequest;
import az.hamburg.instant_goal.dto.response.ManagerResponse;
import az.hamburg.instant_goal.entity.CountryEntity;
import az.hamburg.instant_goal.entity.ManagerEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.ManagerStatus;

import static az.hamburg.instant_goal.mapper.TeamMapper.TEAM_MAPPER;

public enum ManagerMapper {
    MANAGER_MAPPER;

    public ManagerEntity requestToEntity(ManagerRequest request, CountryEntity country, TeamEntity team){
        ManagerEntity build = ManagerEntity.builder()
                .fullName(request.getFullName())
                .numberOfCups(request.getNumberOfCups())
                .age(request.getAge())
                .country(country)
                .status(request.getStatus())
                .team(team)
                .build();

        return build;
    }

    public ManagerResponse entityToResponse(ManagerEntity manager){
        ManagerResponse build = ManagerResponse.builder()
                .id(manager.getId())
                .fullName(manager.getFullName())
                .age(manager.getAge())
                .status(ManagerStatus.ACTIVE)
                .numberOfCups(manager.getNumberOfCups())
                .build();
        return build;
    }
}
