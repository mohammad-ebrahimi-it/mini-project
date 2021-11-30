package com.shop.shopping.services;

import com.shop.shopping.dto.requests.UserRequest;
import com.shop.shopping.model.Users;
import com.shop.shopping.repository.UserRepository;
import com.shop.shopping.services.services.UserServicesInt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServicesInt {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Page<Users> getUser(Pageable pageable) {
            return userRepository.findAll(pageable);
    }

    @Override
    public Users addUser(UserRequest userRequest) {
        Users users= Users.UserBuilder.builder().setFirstName(userRequest.getFirstName())
                .setLastName(userRequest.getLastName())
                .setEmail(userRequest.getEmail())
                .setCover(userRequest.getCover())
                .setPassword(userRequest.getPassword())
                .build();
        return userRepository.save(users);
    }
}
