package az.hamburg.instant_goal.service.abstraction;

import az.hamburg.instant_goal.dto.request.RegisterRequest;
import az.hamburg.instant_goal.dto.response.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest request);
}
