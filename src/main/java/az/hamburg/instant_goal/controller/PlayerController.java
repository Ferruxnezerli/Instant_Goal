package az.hamburg.instant_goal.controller;

import az.hamburg.instant_goal.dto.request.PlayerRequest;
import az.hamburg.instant_goal.dto.response.PlayerResponse;
import az.hamburg.instant_goal.service.abstraction.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE,makeFinal = true)
@RestController
@RequestMapping("api/v1/players")
@RequiredArgsConstructor
public class PlayerController {

    PlayerService playerService;

    @PostMapping
    public String savePlayer(@RequestBody PlayerRequest request) {
        playerService.savePlayer(request);
        return "Saved successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        playerService.deleteById(id);
        return "Deleted successfully!";
    }

    @GetMapping("/{id}")
    PlayerResponse getById(@PathVariable Long id) {
        return playerService.getById(id);
    }

    @GetMapping
    List<PlayerResponse> getAll(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count) {
        return playerService.getAll(page, count);
    }

    @PutMapping("/{id}")
    public String updateById(@PathVariable Long id,@RequestBody PlayerRequest request){
        playerService.updateById(id,request);
        return "Updated successfully!";
    }
}
