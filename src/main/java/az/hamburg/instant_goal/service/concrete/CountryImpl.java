package az.hamburg.instant_goal.service.concrete;

import az.hamburg.instant_goal.dto.request.CountryRequest;
import az.hamburg.instant_goal.dto.response.CountryResponse;
import az.hamburg.instant_goal.entity.CountryEntity;
import az.hamburg.instant_goal.enums.CountryStatus;
import az.hamburg.instant_goal.exception.NotFoundException;
import az.hamburg.instant_goal.mapper.CountryMapper;
import az.hamburg.instant_goal.repository.CountryRepository;
import az.hamburg.instant_goal.service.abstraction.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

import static az.hamburg.instant_goal.mapper.CountryMapper.COUNTRY_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE,makeFinal = true)
@Service
@RequiredArgsConstructor
public class CountryImpl implements CountryService {

    CountryRepository countryRepository;

    @Override
    public void saveCountry(CountryRequest request) {
        CountryEntity countryEntity = COUNTRY_MAPPER.requestToEntity(request);
        countryRepository.save(countryEntity);
    }

    @Override
    public void deleteById(Long id) {
        CountryEntity country = getCountry(id);
        country.setStatus(CountryStatus.INACTIVE);
        countryRepository.save(country);
    }

    @Override
    public CountryResponse getById(Long id) {
        CountryEntity country = getCountry(id);
        CountryResponse countryResponse = COUNTRY_MAPPER.entityToResponse(country);
        return countryResponse;
    }

    @Override
    public List<CountryResponse> getAll(int page,int count) {
        Page<CountryEntity> countries = countryRepository
                .findAll(PageRequest.of(page, count));
        return countries.getContent().stream()
                .map(country
                        -> COUNTRY_MAPPER.entityToResponse(country)).toList();
    }

    @Override
    public void updateById(Long id, CountryRequest request) {
        CountryEntity country = getCountry(id);

        country.setName(request.getName());
        country.setContinent(request.getContinent());


        countryRepository.save(country);
    }

    private CountryEntity getCountry(Long id){
        CountryEntity countryEntity= countryRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Country can't found!"));
        return countryEntity;
    }
}
