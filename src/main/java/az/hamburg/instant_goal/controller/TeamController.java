package az.hamburg.instant_goal.controller;

import az.hamburg.instant_goal.dto.request.MatchRequest;
import az.hamburg.instant_goal.dto.request.TeamRequest;
import az.hamburg.instant_goal.dto.response.TeamResponse;
import az.hamburg.instant_goal.service.abstraction.TeamService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@RestController
@RequestMapping("api/v1/teams")
@RequiredArgsConstructor
public class TeamController {

    TeamService teamService;

    @PostMapping
    public String saveTeam(@RequestBody TeamRequest request) {
        teamService.saveTeam(request);
        return "Saved successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        teamService.deleteById(id);
        return "Deleted successfully!";
    }

    @GetMapping("/{id}")
    public TeamResponse getById(@PathVariable Long id) {
        return teamService.getById(id);
    }

    @GetMapping
    public List<TeamResponse> getAll(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count) {
        return teamService.getAll(page, count);
    }

    @PutMapping("/{id}")
    public String updateById(@PathVariable Long id, @RequestBody TeamRequest request) {
        teamService.updateById(id, request);
        return "Updated successfuly!";
    }
}
