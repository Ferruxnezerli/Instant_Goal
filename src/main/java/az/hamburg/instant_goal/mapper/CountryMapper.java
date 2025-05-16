package az.hamburg.instant_goal.mapper;

import az.hamburg.instant_goal.dto.request.CountryRequest;
import az.hamburg.instant_goal.dto.response.CountryResponse;
import az.hamburg.instant_goal.entity.CountryEntity;
import az.hamburg.instant_goal.enums.CountryStatus;

import static az.hamburg.instant_goal.enums.CountryStatus.ACTIVE;

public enum CountryMapper {
    COUNTRY_MAPPER;

    public CountryEntity requestToEntity(CountryRequest request){
        CountryEntity build = CountryEntity.builder()
                .name(request.getName())
                .status(request.getStatus())
                .continent(request.getContinent())
                .build();

        return build;
    }

    public CountryResponse entityToResponse(CountryEntity country){
        CountryResponse build = CountryResponse.builder()
                .id(country.getId())
                .name(country.getName())
                .continent(country.getContinent())
                .status(ACTIVE)
                .build();

        return build;
    }
}
