package az.hamburg.instant_goal.service.concrete;

import az.hamburg.instant_goal.dto.request.StadiumRequest;
import az.hamburg.instant_goal.dto.response.StadiumResponse;
import az.hamburg.instant_goal.entity.StadiumEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.StadiumStatus;
import az.hamburg.instant_goal.exception.NotFoundException;
import az.hamburg.instant_goal.mapper.StadiumMapper;
import az.hamburg.instant_goal.repository.StadiumRepository;
import az.hamburg.instant_goal.repository.TeamRepository;
import az.hamburg.instant_goal.service.abstraction.StadiumService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.instant_goal.mapper.StadiumMapper.STADIUM_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@Service
@RequiredArgsConstructor
public class StadiumImpl implements StadiumService {

    StadiumRepository stadiumRepository;
    TeamRepository teamRepository;

    @Override
    public void saveStadium(StadiumRequest request) {
        TeamEntity team = teamRepository.findById(request.getTeam_id())
                .orElseThrow(() -> new NotFoundException("Team can't found!"));
        StadiumEntity stadiumEntity = STADIUM_MAPPER.requestToEntity(request, team);
        stadiumRepository.save(stadiumEntity);
    }

    @Override
    public void deleteById(Long id) {
        StadiumEntity stadium = getStadium(id);
        stadium.setStatus(StadiumStatus.INACTIVE);
        stadiumRepository.save(stadium);
    }

    @Override
    public StadiumResponse getById(Long id) {
        StadiumEntity stadium = getStadium(id);
        StadiumResponse stadiumResponse = STADIUM_MAPPER.entityToResponse(stadium);
        return stadiumResponse;
    }

    @Override
    public List<StadiumResponse> getAll(int page,int count) {
        Page<StadiumEntity> stadiums = stadiumRepository.findAll(PageRequest.of(page, count));
      return stadiums.getContent().stream()
                .map(stadium
                        -> STADIUM_MAPPER.entityToResponse(stadium)).toList();
    }

    @Override
    public void updateById(Long id, StadiumRequest request) {
        StadiumEntity stadium = getStadium(id);

        TeamEntity team = teamRepository.findById(request.getTeam_id())
                .orElseThrow(() -> new NotFoundException("Team can't found!"));

        stadium.setName(request.getName());
        stadium.setCapacity(request.getCapacity());
        stadium.setTeam(team);

        stadiumRepository.save(stadium);

    }

    private StadiumEntity getStadium(Long id) {
        StadiumEntity stadiumEntity = stadiumRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Stadium can't found!"));
        return stadiumEntity;
    }
}
