package az.hamburg.instant_goal.controller;

import az.hamburg.instant_goal.dto.request.PlayerStatisticsRequest;
import az.hamburg.instant_goal.dto.response.PlayerStatisticsResponse;
import az.hamburg.instant_goal.service.abstraction.PlayerStatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE,makeFinal = true )
@RestController
@RequestMapping("api/v1/player_statistics")
@RequiredArgsConstructor
public class PlayerStatisticsController {

    PlayerStatisticsService playerStatisticsService;

    @PostMapping
    public String saveStatistics(@RequestBody PlayerStatisticsRequest request){
        playerStatisticsService.saveStatistics(request);
        return "Saved successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        playerStatisticsService.deleteById(id);
        return "Deleted successfully!";
    }

    @GetMapping("/{id}")
    public PlayerStatisticsResponse getById(@PathVariable Long id){
        return playerStatisticsService.getById(id);
    }

    @GetMapping
    public List<PlayerStatisticsResponse> getAll(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count){
        return playerStatisticsService.getAll(page, count);
    }

    @PutMapping("/{id}")
    public String updateById(@PathVariable Long id,@RequestBody PlayerStatisticsRequest request){
        playerStatisticsService.updateById(id,request);
        return "Updated successfully!";
    }

}
