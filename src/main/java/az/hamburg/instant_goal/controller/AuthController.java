package az.hamburg.instant_goal.controller;

import az.hamburg.instant_goal.dto.request.RegisterRequest;
import az.hamburg.instant_goal.dto.response.RegisterResponse;
import az.hamburg.instant_goal.service.abstraction.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE,makeFinal = true)
@RestController
@RequestMapping("/api/auth/v1")
@RequiredArgsConstructor
public class AuthController {

    AuthService authService;

    @PostMapping("/register")
    public RegisterResponse saveUser(@RequestBody RegisterRequest request){
        authService.register(request);
        return new RegisterResponse("User registered");

    }

}
