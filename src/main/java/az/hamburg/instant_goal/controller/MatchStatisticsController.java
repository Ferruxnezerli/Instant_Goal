package az.hamburg.instant_goal.controller;

import az.hamburg.instant_goal.dto.request.MatchStatisticsRequest;
import az.hamburg.instant_goal.dto.response.MatchStatisticsResponse;
import az.hamburg.instant_goal.service.abstraction.MatchStatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE,makeFinal = true)
@RestController
@RequestMapping("api/v1/statistics")
@RequiredArgsConstructor
public class MatchStatisticsController {

    MatchStatisticsService matchStatisticsService;

    @PostMapping
    public String saveStatistics(@RequestBody MatchStatisticsRequest request){
        matchStatisticsService.saveStatistics(request);
        return "Saved successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteStatistics(@PathVariable Long id){
        matchStatisticsService.deleteById(id);
        return "Deeleted successfully!";
    }

    @GetMapping("/{id}")
    public MatchStatisticsResponse getById(@PathVariable Long id){
        return matchStatisticsService.getById(id);
    }

    @GetMapping
    public List<MatchStatisticsResponse> getAll(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count){
        return matchStatisticsService.getAll(page,count);
    }

    @PutMapping("/{id}")
    public String updateById(@PathVariable Long id,@RequestBody MatchStatisticsRequest request){
        matchStatisticsService.updateById(id,request);
        return "Updated successfully!";
    }
}
