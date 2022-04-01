package com.shop.shopping.repository;

import com.shop.shopping.model.category.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories, Long> {
}
