package com.shop.shopping.services.services;

import com.shop.shopping.dto.requests.UserRequest;
import com.shop.shopping.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserServicesInt {
    public Page<Users> getUser(Pageable pageable);
    public Users addUser(UserRequest userRequest);
}
