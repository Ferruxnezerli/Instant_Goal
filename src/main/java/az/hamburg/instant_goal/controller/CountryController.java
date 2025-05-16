package az.hamburg.instant_goal.controller;

import az.hamburg.instant_goal.dto.request.CountryRequest;
import az.hamburg.instant_goal.dto.response.CountryResponse;
import az.hamburg.instant_goal.service.abstraction.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE,makeFinal = true)
@RestController
@RequestMapping("api/v1/countries")
@RequiredArgsConstructor
public class CountryController {

    CountryService countryService;

    @PostMapping
    public String saveCountry(@RequestBody CountryRequest request){
        countryService.saveCountry(request);
        return "Saved successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        countryService.deleteById(id);
        return "Deleted successfully;";
    }

    @GetMapping("/{id}")
    public CountryResponse getById(@PathVariable Long id){
       return countryService.getById(id);
    }

    @GetMapping
    public List<CountryResponse> getAll(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count){
        return countryService.getAll(page,count);
    }

    @PutMapping("/{id}")
    public String updateById(@PathVariable Long id,@RequestBody CountryRequest request){
        countryService.updateById(id,request);
        return "Updated successfully!";
    }
}
