package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService) { // 생성자 추가
        this.userService = userService;
    }

    @PostMapping("/user") // POST /user
    public void createUser(@RequestBody UserCreateRequest request) {
        userService.createUser(request);
    }

    @GetMapping("/user") // GET /user
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user") // PUT /user
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user") // DELETE /user
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }
}
