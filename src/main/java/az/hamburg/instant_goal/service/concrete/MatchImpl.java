package az.hamburg.instant_goal.service.concrete;

import az.hamburg.instant_goal.dto.request.MatchRequest;
import az.hamburg.instant_goal.dto.response.MatchResponse;
import az.hamburg.instant_goal.entity.MatchEntity;
import az.hamburg.instant_goal.entity.MatchStatisticsEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.MatchStatus;
import az.hamburg.instant_goal.exception.NotFoundException;
import az.hamburg.instant_goal.mapper.MatchMapper;
import az.hamburg.instant_goal.repository.MatchRepositroy;
import az.hamburg.instant_goal.repository.MatchStatisticsRepository;
import az.hamburg.instant_goal.repository.TeamRepository;
import az.hamburg.instant_goal.service.abstraction.MatchService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.instant_goal.mapper.MatchMapper.MATCH_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@Service
@RequiredArgsConstructor
public class MatchImpl implements MatchService {

    MatchRepositroy matchRepositroy;
    TeamRepository teamRepository;

    @Override
    public void saveMatch(MatchRequest request) {
        TeamEntity homeTeam = teamRepository.findById(request.getHome_id()).orElseThrow(()
                -> new NotFoundException("Team can't found!"));

        TeamEntity awayTeam = teamRepository.findById(request.getHome_id()).orElseThrow(()
                -> new NotFoundException("Team can't found!"));


        MatchEntity match = MATCH_MAPPER.requestToentity(request, homeTeam, awayTeam);
        matchRepositroy.save(match);
    }

    @Override
    public void deleteById(Long id) {
        matchRepositroy.deleteById(id);
    }

    @Override
    public MatchResponse getById(Long id) {
        MatchEntity match = getMatch(id);
        MatchResponse matchResponse = MATCH_MAPPER.entityToResponse(match);
        return matchResponse;
    }

    @Override
    public List<MatchResponse> getAll(int page, int count) {
        Page<MatchEntity> matches = matchRepositroy.findAll(PageRequest.of(page, count));
        return matches.getContent().stream()
                .map(match
                        -> MATCH_MAPPER.entityToResponse(match)).toList();

    }

    @Override
    public void updateById(Long id, MatchRequest request) {
        MatchEntity match = getMatch(id);

        TeamEntity homeTeam = teamRepository.findById(request.getHome_id()).orElseThrow(()
                -> new NotFoundException("Team can't found!"));

        TeamEntity awayTeam = teamRepository.findById(request.getHome_id()).orElseThrow(()
                -> new NotFoundException("Team can't found!"));

        match.setMatchType(request.getMatchType());
          match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);

        matchRepositroy.save(match);
    }

    private MatchEntity getMatch(Long id) {
        MatchEntity match = matchRepositroy.findById(id)
                .orElseThrow(() -> new NotFoundException("Match can't found!"));
        return match;
    }
}
