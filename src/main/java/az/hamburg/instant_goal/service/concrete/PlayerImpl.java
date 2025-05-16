package az.hamburg.instant_goal.service.concrete;

import az.hamburg.instant_goal.dto.request.PlayerRequest;
import az.hamburg.instant_goal.dto.response.PlayerResponse;
import az.hamburg.instant_goal.entity.CountryEntity;
import az.hamburg.instant_goal.entity.NationalTeamEntity;
import az.hamburg.instant_goal.entity.PlayerEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.exception.NotFoundException;
import az.hamburg.instant_goal.repository.CountryRepository;
import az.hamburg.instant_goal.repository.PlayerRepository;
import az.hamburg.instant_goal.repository.TeamRepository;
import az.hamburg.instant_goal.service.abstraction.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.instant_goal.enums.PlayerStatus.INACTIVE;
import static az.hamburg.instant_goal.mapper.PlayerMapper.PLAYER_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE,makeFinal = true)
public class PlayerImpl implements PlayerService {

    PlayerRepository playerRepository;
    TeamRepository teamRepository;
    CountryRepository countryRepository;
NationalTeamRepository nationalTeamRepository;

    @Override
    public void savePlayer(PlayerRequest request) {

        TeamEntity teamEntity = teamRepository.findById(request.getTeam_id()).orElseThrow(()
                -> new NotFoundException("Team can't found!"));
        CountryEntity countryEntity= countryRepository.findById(request.getCountry_id()).orElseThrow(()
                -> new NotFoundException("Country can't found!"));
        NationalTeamEntity nationalTeamEntity = nationalTeamRepository.findById(request.getNationalTeam_id())
                .orElseThrow(() -> new NotFoundException("National team can't found!"));


        PlayerEntity player = PLAYER_MAPPER.requestToEntity(request,teamEntity,countryEntity,nationalTeamEntity);
        playerRepository.save(player);
    }

    @Override
    public void deleteById(Long id) {
        PlayerEntity player = getPlayer(id);
        player.setStatus(INACTIVE);
        playerRepository.save(player);
    }

    @Override
    public PlayerResponse getById(Long id) {
        PlayerEntity player = getPlayer(id);
        PlayerResponse playerResponse = PLAYER_MAPPER.entityToResponse(player);
        return playerResponse;

    }

    @Override
    public List<PlayerResponse> getAll(int page,int count) {
        Page<PlayerEntity> players = playerRepository.findAll(PageRequest.of(page, count));
       return players.getContent().stream()
                .map(player
                        -> PLAYER_MAPPER.entityToResponse(player)).toList();

    }

    @Override
    public void updateById(Long id, PlayerRequest request) {
        PlayerEntity player = getPlayer(id);

        TeamEntity teamEntity = teamRepository.findById(request.getTeam_id()).orElseThrow(()
                -> new NotFoundException("Team can't found!"));
        CountryEntity countryEntity= countryRepository.findById(request.getCountry_id()).orElseThrow(()
                -> new NotFoundException("Country can't found!"));

        player.setName(request.getName());
        player.setAge(request.getAge());
        player.setPosition(request.getPosition());
        player.setBirthDate(request.getBirthDate());
        player.setJerseyNumber(request.getJerseyNumber());
        player.setIsCaptain(request.getIsCaptain());
        player.setTeam(teamEntity);
        player.setCountry(countryEntity);

        playerRepository.save(player);
    }

    private PlayerEntity getPlayer(Long id){
        PlayerEntity player = playerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Player can't found!"));
        return player;
    }
}
