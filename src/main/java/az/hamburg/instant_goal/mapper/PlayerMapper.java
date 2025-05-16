package az.hamburg.instant_goal.mapper;

import az.hamburg.instant_goal.dto.request.PlayerRequest;
import az.hamburg.instant_goal.dto.response.PlayerResponse;
import az.hamburg.instant_goal.entity.CountryEntity;
import az.hamburg.instant_goal.entity.PlayerEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.PlayerStatus;

public enum PlayerMapper {
    PLAYER_MAPPER;

    public PlayerEntity requestToEntity(PlayerRequest request, TeamEntity team, CountryEntity country) {
        PlayerEntity build = PlayerEntity.builder()
                .name(request.getName())
                .age(request.getAge())
                .birthDate(request.getBirthDate())
                .jerseyNumber(request.getJerseyNumber())
                .isCaptain(request.getIsCaptain())
                .position(request.getPosition())
                .status(request.getStatus())
                .team(team)
                .country(country)
                .build();

        return build;
    }

   public PlayerResponse entityToResponse(PlayerEntity player){
        PlayerResponse build2 = PlayerResponse.builder()
                .id(player.getId())
                .name(player.getName())
                .age(player.getAge())
                .birthDate(player.getBirthDate())
                .jerseyNumber(player.getJerseyNumber())
                .isCaptain(player.getIsCaptain())
                .position(player.getPosition())
                .status(PlayerStatus.ACTIVE)
                .build();

        return build2;
    }
}
