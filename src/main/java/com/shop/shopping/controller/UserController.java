package com.shop.shopping.controller;

import com.shop.shopping.dto.requests.UserRequest;
import com.shop.shopping.dto.response.UserResponse;
import com.shop.shopping.model.Users;
import com.shop.shopping.services.services.UserServicesInt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserServicesInt userServicesInt;

    public UserController(UserServicesInt userServicesInt) {
        this.userServicesInt = userServicesInt;
    }

    @GetMapping("/")
    public Page<Users> users (Pageable pageable) {
        return userServicesInt.getUser(pageable);
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUsers(@RequestBody UserRequest request) {
        Users users = userServicesInt.addUser(request);
        return ResponseEntity.ok(userResponse(users));
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
