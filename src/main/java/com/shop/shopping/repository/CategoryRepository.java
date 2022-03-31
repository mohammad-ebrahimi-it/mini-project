package com.shop.shopping.repository;

import com.shop.shopping.model.Categoreis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categoreis, Long> {
}
