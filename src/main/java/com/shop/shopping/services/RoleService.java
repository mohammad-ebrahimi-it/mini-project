package com.shop.shopping.services;

import com.shop.shopping.dto.requests.RoleRequest;
import com.shop.shopping.dto.response.RoleResponse;
import com.shop.shopping.exception.ResourceNotFoundException;
import com.shop.shopping.model.role.RoleBuilder;
import com.shop.shopping.model.role.Roles;
import com.shop.shopping.repository.RoleRepository;
import com.shop.shopping.services.services.RoleServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RoleService implements RoleServiceInt {

    private final RoleRepository roleRepository;
    private final MessageSourceAccessor messageSourceAccessor;

    @Override
    public Roles addRole(RoleRequest roleRequest) {

        Roles role = RoleBuilder.builder()
                .setName(roleRequest.getName().toUpperCase())
                .setPersianName(roleRequest.getPersianName())
                .build();
        return roleRepository.save(role);
    }

    @Override
    public Roles getById(Long id) {
        return roleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(
                        messageSourceAccessor.getMessage("role.not.found")));
    }

    @Override
    public Page<Roles> getAll(Pageable pageable) {
       return roleRepository.findAll(pageable);
    }


}
