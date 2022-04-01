package com.shop.shopping.services.services;

import com.shop.shopping.dto.requests.UserRequest;
import com.shop.shopping.model.role.Roles;
import com.shop.shopping.model.user.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserServicesInt {

    Users saveUser(Users user);

    Roles savaRole(Roles roles);

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
