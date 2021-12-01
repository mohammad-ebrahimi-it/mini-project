package com.shop.shopping.services;

import com.shop.shopping.dto.requests.UserRequest;
import com.shop.shopping.model.Users;
import com.shop.shopping.repository.UserRepository;
import com.shop.shopping.services.services.UserServicesInt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.ExpressionException;
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
        Users users = Users.UserBuilder.builder().setFirstName(userRequest.getFirstName())
                .setLastName(userRequest.getLastName())
                .setEmail(userRequest.getEmail())
                .setCover(userRequest.getCover())
                .setPassword(userRequest.getPassword())
                .build();
        return userRepository.save(users);
    }

    @Override
    public Users update(UserRequest userRequest, Long id) {
        Users users = userRepository.findById(id).orElseThrow(RuntimeException::new);
        users.setFirstName(userRequest.getFirstName());
        users.setLastName(userRequest.getLastName());
        users.setPassword(userRequest.getPassword());
        users.setCover(userRequest.getCover());
        users.setEmail(userRequest.getEmail());

        return userRepository.save(users);
    }

    @Override
    public Users findOneUsers(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteUsers(Long id) {
        userRepository.deleteById(id);
    }
}
