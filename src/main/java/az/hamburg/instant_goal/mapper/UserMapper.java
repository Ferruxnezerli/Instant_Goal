//package az.hamburg.instant_goal.mapper;
//
//import az.hamburg.instant_goal.dto.request.RegisterRequest;
//import az.hamburg.instant_goal.dto.response.RegisterResponse;
//import az.hamburg.instant_goal.entity.UserEntity;
//
//public enum UserMapper {
//    USER_MAPPER;
//
//    public UserEntity reuqestToEntity(RegisterRequest request){
//        UserEntity build = UserEntity.builder()
//                .name(request.getName())
//                .password(request.getPassword())
//                .userStatus(request.getUserStatus())
//                .build();
//
//        return build;
//    }
//
//    public RegisterResponse entityToResponse(UserEntity user){
//        RegisterResponse build = RegisterResponse.builder()
//                .id(user.getId())
//                .name(user.getName())
//                .password(user.getPassword())
//                .userStatus(user.getUserStatus())
//                .build();
//
//        return build;
//    }
//}
