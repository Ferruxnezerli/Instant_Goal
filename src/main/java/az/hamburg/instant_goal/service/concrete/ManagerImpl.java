package az.hamburg.instant_goal.service.concrete;

import az.hamburg.instant_goal.dto.request.ManagerRequest;
import az.hamburg.instant_goal.dto.response.ManagerResponse;
import az.hamburg.instant_goal.entity.CountryEntity;
import az.hamburg.instant_goal.entity.ManagerEntity;
import az.hamburg.instant_goal.entity.TeamEntity;
import az.hamburg.instant_goal.enums.ManagerStatus;
import az.hamburg.instant_goal.exception.NotFoundException;
import az.hamburg.instant_goal.mapper.ManagerMapper;
import az.hamburg.instant_goal.repository.CountryRepository;
import az.hamburg.instant_goal.repository.ManagerRepository;
import az.hamburg.instant_goal.repository.TeamRepository;
import az.hamburg.instant_goal.service.abstraction.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static az.hamburg.instant_goal.mapper.ManagerMapper.MANAGER_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@Service
@RequiredArgsConstructor
public class ManagerImpl implements ManagerService {

    ManagerRepository managerRepository;
    CountryRepository countryRepository;
    TeamRepository teamRepository;

    @Override
    public void saveManager(ManagerRequest request) {
        CountryEntity countryEntity = countryRepository.findById(request.getCountry_id()).orElseThrow(()
                -> new NotFoundException("Country can't found!"));
        TeamEntity team = teamRepository.findById(request.getTeam_id())
                .orElseThrow(() -> new NotFoundException("Team can't found!"));
        ManagerEntity managerEntity = MANAGER_MAPPER.requestToEntity(request, countryEntity,team);
        managerRepository.save(managerEntity);
    }

    @Override
    public void deleteById(Long id) {
        ManagerEntity manager = getManager(id);
        manager.setStatus(ManagerStatus.INACTIVE);
    }

    @Override
    public ManagerResponse getById(Long id) {
        ManagerEntity manager = getManager(id);
        ManagerResponse managerResponse = MANAGER_MAPPER.entityToResponse(manager);
        return managerResponse;
    }

    @Override
    public List<ManagerResponse> getAll(int page,int count) {
        Page<ManagerEntity> managers = managerRepository.findAll(PageRequest.of(page, count));

        return managers.getContent().stream()
                .map(manager
                -> MANAGER_MAPPER.entityToResponse(manager)).toList();
    }

    @Override
    public void updateById(Long id, ManagerRequest request) {
        ManagerEntity manager = getManager(id);

        CountryEntity countryEntity= countryRepository.findById(request.getCountry_id()).orElseThrow(()
                -> new NotFoundException("Country can't found!"));

        TeamEntity team = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Team can't found!"));

        manager.setFullName(request.getFullName());
        manager.setAge(request.getAge());
        manager.setNumberOfCups(request.getNumberOfCups());
        manager.setCountry(countryEntity);
        manager.setTeam(team);

        managerRepository.save(manager);
    }

    private ManagerEntity getManager(Long id) {
        ManagerEntity managerEntity = managerRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Manager can't found!"));
        return managerEntity;
    }
}
