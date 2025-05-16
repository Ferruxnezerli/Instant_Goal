package az.hamburg.instant_goal.service.abstraction;

import az.hamburg.instant_goal.dto.request.ManagerRequest;
import az.hamburg.instant_goal.dto.response.ManagerResponse;

import java.util.List;

public interface ManagerService {
    void saveManager(ManagerRequest request);
    void deleteById(Long id);
    ManagerResponse getById(Long id);
    List<ManagerResponse> getAll(int page,int count);
    void updateById(Long id,ManagerRequest request);
}
