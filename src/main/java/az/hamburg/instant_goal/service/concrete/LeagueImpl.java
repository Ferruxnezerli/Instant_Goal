package az.hamburg.instant_goal.service.concrete;

import az.hamburg.instant_goal.dto.request.LeagueRequest;
import az.hamburg.instant_goal.dto.response.LeagueResponse;
import az.hamburg.instant_goal.entity.CountryEntity;
import az.hamburg.instant_goal.entity.LeagueEntity;
import az.hamburg.instant_goal.enums.LeagueStatus;
import az.hamburg.instant_goal.exception.NotFoundException;
import az.hamburg.instant_goal.mapper.LeagueMapper;
import az.hamburg.instant_goal.repository.CountryRepository;
import az.hamburg.instant_goal.repository.LeagueRepository;
import az.hamburg.instant_goal.service.abstraction.LeagueService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.instant_goal.mapper.LeagueMapper.LEAGUE_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@Service
@RequiredArgsConstructor
public class LeagueImpl implements LeagueService {

    LeagueRepository leagueRepository;
    CountryRepository countryRepository;

    @Override
    public void saveLeague(LeagueRequest request) {
        CountryEntity countryEntity = countryRepository.findById(request.getCountry_id()).orElseThrow(()
                -> new NotFoundException("Country can't found!"));

        LeagueEntity leagueEntity = LEAGUE_MAPPER.requestToEntity(request, countryEntity);
        leagueRepository.save(leagueEntity);
    }

    @Override
    public void deleteById(Long id) {
        LeagueEntity league = getLeague(id);

        league.setStatus(LeagueStatus.INACTIVE);
    }

    @Override
    public LeagueResponse getById(Long id) {
        LeagueEntity league = getLeague(id);
        LeagueResponse leagueResponse = LEAGUE_MAPPER.entityToResponse(league);
        return leagueResponse;
    }

    @Override
    public List<LeagueResponse> getAll(int page,int count) {
        Page<LeagueEntity> leagues = leagueRepository.findAll(PageRequest.of(page, count));
        List<LeagueResponse> leagueResponses = leagues.getContent().stream().map(league
                -> LEAGUE_MAPPER.entityToResponse(league)).toList();
        return leagueResponses;
    }

    @Override
    public void updateById(Long id, LeagueRequest request) {
        LeagueEntity league = getLeague(id);

        CountryEntity countryEntity= countryRepository.findById(request.getCountry_id()).orElseThrow(()
                -> new NotFoundException("Country can't found!"));

        league.setName(request.getName());
        league.setNumberOfTeams(request.getNumberOfTeams());
        league.setCountry(countryEntity);

        leagueRepository.save(league);
    }

    private LeagueEntity getLeague(Long id) {
        LeagueEntity leagueEntity = leagueRepository.findById(id).orElseThrow(()
                -> new NotFoundException("League can't found!"));
        return leagueEntity;
    }
}
