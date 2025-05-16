package az.hamburg.instant_goal.controller;

import az.hamburg.instant_goal.dto.request.StadiumRequest;
import az.hamburg.instant_goal.dto.response.StadiumResponse;
import az.hamburg.instant_goal.service.abstraction.StadiumService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE,makeFinal = true)
@RestController
@RequestMapping("api/v1/stadiums")
@RequiredArgsConstructor
public class StadiumController {

    StadiumService stadiumService;

    @PostMapping
    public String saveStadium(@RequestBody StadiumRequest request){
        stadiumService.saveStadium(request);
        return "Saved successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        stadiumService.deleteById(id);
        return "Deleted successfully!";
    }

    @GetMapping("/{id}")
    public StadiumResponse getById(@PathVariable Long id){
        return stadiumService.getById(id);
    }

    @GetMapping
    public List<StadiumResponse> getAll(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count){
        return stadiumService.getAll(page, count);
    }

    @PutMapping("/{id}")
    public String updateById(@PathVariable Long id,@RequestBody StadiumRequest request){
        stadiumService.updateById(id,request);
        return "Updated successfully!";
    }
}
