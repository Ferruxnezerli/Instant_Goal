package az.hamburg.instant_goal.controller;

import az.hamburg.instant_goal.dto.request.ManagerRequest;
import az.hamburg.instant_goal.dto.response.ManagerResponse;
import az.hamburg.instant_goal.service.abstraction.ManagerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE,makeFinal = true)
@RestController
@RequestMapping("api/v1/managers")
@RequiredArgsConstructor
public class ManagerController {

    ManagerService managerService;

    @PostMapping
    public String saveManager(@RequestBody ManagerRequest request) {
        managerService.saveManager(request);
        return "Saved successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        managerService.deleteById(id);
        return "Deeleted successfully!";
    }

    @GetMapping("/{id}")
    public ManagerResponse getById(@PathVariable Long id) {
        return managerService.getById(id);
    }

    @GetMapping
    public List<ManagerResponse> getAll(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count) {
        return managerService.getAll(page,count);
    }

    public String updateById(@PathVariable Long id,@RequestBody ManagerRequest request){
        managerService.updateById(id,request);
        return "Update successfully!";
    }
}
