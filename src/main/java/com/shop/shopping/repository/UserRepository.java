package com.shop.shopping.repository;

import com.shop.shopping.model.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

//    Optional<UserDetails> findByUsername(String username);
}
