package com.shop.shopping.services;

import com.shop.shopping.dto.requests.UserRequest;
import com.shop.shopping.exception.APIException;
import com.shop.shopping.model.Role;
import com.shop.shopping.model.Users;
import com.shop.shopping.repository.*;
import com.shop.shopping.services.services.UserServicesInt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserService implements UserServicesInt , UserDetailsService {

    private final MessageSourceAccessor messageSourceAccessor;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(MessageSourceAccessor messageSourceAccessor, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.messageSourceAccessor = messageSourceAccessor;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found in the database");
        Collection <SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));

        });
        return new User(user.getUsername(), user.getPassword(), authorities);
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
    @Override
    public Users saveUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role savaRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {} ", roleName, username);
        Users user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public Users getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Users> getUsers() {
        return userRepository.findAll();
    }
}
