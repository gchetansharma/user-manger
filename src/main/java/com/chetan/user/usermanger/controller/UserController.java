package com.chetan.user.usermanger.controller;

import com.chetan.user.usermanger.controller.dto.UserRequest;
import com.chetan.user.usermanger.controller.dto.UserResponse;
import com.chetan.user.usermanger.domain.User;
import com.chetan.user.usermanger.exceptions.UserNotFoundException;
import com.chetan.user.usermanger.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        User savedUser = userRepository.save(userRequest.toUser());

        return UserResponse.fromUser(savedUser);

    }

    @DeleteMapping("/delete/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String userId) {

    }

    @GetMapping("/get/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUser(@PathVariable String userId) {
        return userRepository.findById(userId)
                .map(UserResponse::fromUser)
                .orElseThrow(()-> new UserNotFoundException(userId));
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::fromUser)
                .collect(Collectors.toList());

    }

    @PutMapping("/update/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updateUser(@PathVariable String userId, @RequestBody UserRequest userRequest) {

        return new UserResponse();

    }
}
