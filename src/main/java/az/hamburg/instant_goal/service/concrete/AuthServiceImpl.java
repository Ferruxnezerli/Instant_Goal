package az.hamburg.instant_goal.service.concrete;

import az.hamburg.instant_goal.dto.request.RegisterRequest;
import az.hamburg.instant_goal.dto.response.RegisterResponse;
import az.hamburg.instant_goal.entity.UserEntity;
import az.hamburg.instant_goal.exception.AlreadyExistException;
import az.hamburg.instant_goal.exception.NotFoundException;
import az.hamburg.instant_goal.repository.UserRepository;
import az.hamburg.instant_goal.service.abstraction.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    PasswordEncoder encoder;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        if (userRepository.existsByUserName(request.getUserName())) {
            throw  new AlreadyExistException("already exist!");

        } else {

            UserEntity user = new UserEntity();

            user.setUserName(request.getUserName());
            user.setPassword(encoder.encode(request.getPassword()));
            userRepository.save(user);
            return new RegisterResponse("User registered!");
        }
    }
}

