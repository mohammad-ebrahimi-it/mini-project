package com.shop.shopping.services.services;

import com.shop.shopping.dto.requests.RoleRequest;
import com.shop.shopping.model.role.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleServiceInt {
    Roles addRole(RoleRequest roleRequest);

    Page<Roles> getAll(Pageable pageable);

    Roles getById(Long id);
}
