package az.hamburg.instant_goal.controller;

import az.hamburg.instant_goal.dto.request.LeagueRequest;
import az.hamburg.instant_goal.dto.response.LeagueResponse;
import az.hamburg.instant_goal.service.abstraction.LeagueService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@RestController
@RequestMapping("api/v1/leagues")
@RequiredArgsConstructor
public class LeagueController {

    LeagueService leagueService;

    @PostMapping
    public String saveLeague(@RequestBody LeagueRequest request) {
        leagueService.saveLeague(request);
        return "Saved successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        leagueService.deleteById(id);
        return "Deleted successfully!";
    }

    @GetMapping("/{id}")
    public LeagueResponse getById(@PathVariable Long id) {
        return leagueService.getById(id);
    }

    @GetMapping
    public List<LeagueResponse> getAll(@RequestParam(value = "page") int page, @RequestParam(value = "count") int count) {
        return leagueService.getAll(page, count);
    }

    @PutMapping("/{id}")
    public String updateById(@PathVariable Long id, @RequestBody LeagueRequest request) {
        leagueService.updateById(id, request);
        return "Updated successfully!";
    }

}
