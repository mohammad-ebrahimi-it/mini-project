package com.shop.shopping.services;

import com.shop.shopping.dto.requests.UserRequest;
import com.shop.shopping.exception.APIException;
import com.shop.shopping.model.Users;
import com.shop.shopping.repository.UserRepository;
import com.shop.shopping.services.services.UserServicesInt;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServicesInt {

    private final MessageSourceAccessor messageSourceAccessor;
    private final UserRepository userRepository;

    public UserService(MessageSourceAccessor messageSourceAccessor, UserRepository userRepository) {
        this.messageSourceAccessor = messageSourceAccessor;
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
        return userRepository.findById(id).orElseThrow(
                () -> new APIException(messageSourceAccessor.getMessage("user.not.found")));
    }

    @Override
    public void deleteUsers(Long id) {
        userRepository.deleteById(id);
    }
}
