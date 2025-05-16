package az.hamburg.instant_goal.controller;

import az.hamburg.instant_goal.dto.request.MatchRequest;
import az.hamburg.instant_goal.dto.response.MatchResponse;
import az.hamburg.instant_goal.service.abstraction.MatchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE,makeFinal = true)
@RestController
@RequestMapping("api/v1/matches")
@RequiredArgsConstructor
public class MatchController {

    MatchService matchService;

    @PostMapping
    public String saveMatch(@RequestBody MatchRequest request) {
        matchService.saveMatch(request);
        return "Saved successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        matchService.deleteById(id);
        return "Deleted successfully!";
    }

    @GetMapping("/{id}")
    public MatchResponse getById(@PathVariable Long id) {
        return matchService.getById(id);
    }

    @GetMapping
    public List<MatchResponse> getAll(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count){
        return matchService.getAll(page,count);
    }

    @PutMapping("/{id}")
    public String upateById(@PathVariable Long id,@RequestBody MatchRequest request){
        matchService.updateById(id,request);
        return "Updated successfully!";
    }

}
