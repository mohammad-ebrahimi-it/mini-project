package com.shop.shopping.controller;

import com.shop.shopping.dto.requests.UserRequest;
import com.shop.shopping.dto.response.UserResponse;
import com.shop.shopping.model.Users;
import com.shop.shopping.services.services.UserServicesInt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserServicesInt userServicesInt;

    public UserController(UserServicesInt userServicesInt) {
        this.userServicesInt = userServicesInt;
    }

    @GetMapping("/")
    public Page<Users> users(Pageable pageable) {
        return userServicesInt.getUser(pageable);
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUsers(@RequestBody UserRequest request) {
        Users users = userServicesInt.addUser(request);
        return ResponseEntity.ok(userResponse(users));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        Users user = userServicesInt.update(userRequest, id);
        return ResponseEntity.ok(userResponse(user));

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponse> findUser(@PathVariable Long id) {
        Users users = userServicesInt.findOneUsers(id);
        return ResponseEntity.ok(userResponse(users));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable Long id) {
        userServicesInt.deleteUsers(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    private UserResponse userResponse(Users user) {
        return UserResponse.UserResponseBuilder.builder()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setCover(user.getCover())
                .setEmail(user.getEmail())
                .setCover(user.getCover())
                .setPosts(user.getPosts())
                .build();
    }

}
