package com.shop.shopping.services.services;

import com.shop.shopping.dto.requests.UserRequest;
import com.shop.shopping.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserServicesInt {
    Page<Users> getUser(Pageable pageable);

    Users addUser(UserRequest userRequest);

    Users update(UserRequest userRequest, Long id);

    Users findOneUsers(Long id);

    void deleteUsers(Long id);
}
