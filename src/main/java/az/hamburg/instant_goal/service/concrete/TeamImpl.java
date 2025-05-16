package az.hamburg.instant_goal.service.concrete;

import az.hamburg.instant_goal.dto.request.TeamRequest;
import az.hamburg.instant_goal.dto.response.TeamResponse;
import az.hamburg.instant_goal.entity.LeagueEntity;
import az.hamburg.instant_goal.entity.ManagerEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.TeamStatus;
import az.hamburg.instant_goal.exception.NotFoundException;
import az.hamburg.instant_goal.mapper.TeamMapper;
import az.hamburg.instant_goal.repository.LeagueRepository;
import az.hamburg.instant_goal.repository.ManagerRepository;
import az.hamburg.instant_goal.repository.TeamRepository;
import az.hamburg.instant_goal.service.abstraction.TeamService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.instant_goal.mapper.TeamMapper.TEAM_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE,makeFinal = true)
@Service
@RequiredArgsConstructor
public class TeamImpl implements TeamService {

    TeamRepository teamRepository;
    LeagueRepository leagueRepository;

    @Override
    public void saveTeam(TeamRequest request) {
        LeagueEntity leagueEntity = leagueRepository.findById(request.getLeague_id()).orElseThrow(()
                -> new NotFoundException("League can not found!"));

        TeamEntity team = TEAM_MAPPER.requestToEntity(request,leagueEntity);
        teamRepository.save(team);
    }

    @Override
    public void deleteById(Long id) {
        TeamEntity team = getTeam(id);
        team.setStatus(TeamStatus.INACTIVE);
        teamRepository.save(team);
    }

    @Override
    public TeamResponse getById(Long id) {
        TeamEntity team = getTeam(id);
        TeamResponse teamResponse = TEAM_MAPPER.entityToResponse(team);
        return teamResponse;
    }

    @Override
    public List<TeamResponse> getAll(int page,int count) {
        Page<TeamEntity> teams = teamRepository.findAll(PageRequest.of(page, count));
       return teams.getContent().stream()
                .map(team -> TEAM_MAPPER.entityToResponse(team)).toList();

    }

    @Override
    public void updateById(Long id, TeamRequest request) {
        TeamEntity team = getTeam(id);


        LeagueEntity leagueEntity = leagueRepository.findById(id).orElseThrow(()
                -> new NotFoundException("League can't found!"));

        team.setName(request.getName());
        team.setFoundYear(request.getFoundYear());
        team.setNumberOfCups(request.getNumberOfCups());
        team.setLeague(leagueEntity);

        teamRepository.save(team);
    }

    private TeamEntity getTeam(Long id){
        TeamEntity team = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Team can't found!"));
        return team;
    }
}
