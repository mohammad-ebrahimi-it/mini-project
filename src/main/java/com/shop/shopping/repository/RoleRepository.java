package com.shop.shopping.repository;

import com.shop.shopping.model.role.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface  RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}
