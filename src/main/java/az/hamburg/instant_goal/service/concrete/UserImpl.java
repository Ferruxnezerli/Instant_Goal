//package az.hamburg.instant_goal.service.concrete;
//
//import az.hamburg.instant_goal.dto.request.RegisterRequest;
//import az.hamburg.instant_goal.dto.response.RegisterResponse;
//import az.hamburg.instant_goal.entity.UserEntity;
//import az.hamburg.instant_goal.enums.UserStatus;
//import az.hamburg.instant_goal.exception.NotFoundException;
//import az.hamburg.instant_goal.mapper.UserMapper;
//import az.hamburg.instant_goal.repository.UserRepository;
//import az.hamburg.instant_goal.service.abstraction.UserService;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//import static lombok.AccessLevel.PRIVATE;
//
//@FieldDefaults(level = PRIVATE, makeFinal = true)
//@Service
//@RequiredArgsConstructor
//public class UserImpl implements UserService {
//
//    UserRepository userRepository;
//
//    @Override
//    public void saveUser(RegisterRequest request) {
//        UserEntity userEntity = UserMapper.USER_MAPPER.reuqestToEntity(request);
//        userRepository.save(userEntity);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        UserEntity user = getUser(id);
//        user.setUserStatus(UserStatus.INACTIVE);
//        userRepository.save(user);
//    }
//
//    @Override
//    public RegisterResponse getById(Long id) {
//        UserEntity user = getUser(id);
//        RegisterResponse userResponse = UserMapper.USER_MAPPER.entityToResponse(user);
//        return userResponse;
//    }
//
//    @Override
//    public List<RegisterResponse> getAll(int page, int count) {
//        Page<UserEntity> users = userRepository.findAll(PageRequest.of(page, count));
//        List<RegisterResponse> userResponses = users.getContent().stream()
//                .map(user -> UserMapper.USER_MAPPER.entityToResponse(user))
//                .toList();
//        return userResponses;
//    }
//
//    @Override
//    public void updateById(Long id, RegisterRequest request) {
//        UserEntity user = getUser(id);
//
//        user.setName(request.getName());
//        user.setPassword(request.getPassword());
//    }
//
//    private UserEntity getUser(Long id) {
//        UserEntity userEntity = userRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("User can't found!"));
//        return userEntity;
//    }
//}
