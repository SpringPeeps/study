package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;
    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유저 저장 기능: save 메소드에 객체를 넣어주면 INSERT sql이 자동으로 요청됨
    @Transactional
    public void createUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.getName(), request.getAge()));
//        throw new IllegalArgumentException(); // 저장은 됐는데 오류가 발생했으니 저장로직까지 전부 롤백되어서 저장이 안 될 것!
    }

    // 유저 조회 기능
    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge())) // .map(UserResponse::new) 로 대체 가능
                        .collect(Collectors.toList());
    }

    // 유저 업데이트 기능
    @Transactional
    public void updateUser(UserUpdateRequest request) {
        // 1. id를 이용해 user를 가져와서 해당 user가 데이터베이스에 존재하는지 하지 않는지 확인
        User user = userRepository.findById(request.getId())
                        .orElseThrow(); // IllegalAccessException::new 왜 오류나지..?

        // 2. user가 있다면 update 쿼리를 날려서 데이터를 수정
        user.updateName(request.getName());
        // userRepository.save(user);
    }

    // 유저 삭제 기능
    @Transactional
    public void deleteUser(String name) {
        // 사용자 이름으로 유저 가져오기
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        userRepository.delete(user);
    }

}
