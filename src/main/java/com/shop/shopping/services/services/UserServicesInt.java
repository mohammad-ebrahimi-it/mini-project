package com.shop.shopping.services.services;

import com.shop.shopping.dto.requests.UserRequest;
import com.shop.shopping.model.Role;
import com.shop.shopping.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserServicesInt {

    Users saveUser(Users user);

    Role savaRole(Role role);

     UserDetails loadUserByUsername(String username) throws UsernameNotFoundException ;

     void addRoleToUser(String username, String roleName);

    Users getUser(String username);

    List<Users> getUsers();

    Page<Users> getUser(Pageable pageable);

    Users addUser(UserRequest userRequest);

    Users update(UserRequest userRequest, Long id);

    Users findOneUsers(Long id);

    void deleteUsers(Long id);
}
