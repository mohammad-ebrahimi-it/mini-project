package com.shop.shopping.services;

import com.shop.shopping.model.category.Categories;
import com.shop.shopping.model.category.CategoryBuilder;
import com.shop.shopping.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Categories save(Categories categories) {
        System.out.println(categories.getTitle());
        Categories category = CategoryBuilder.categoryBuilder()
                .setTitle(categories.getTitle())
                .build();
        return categoryRepository.save(category);
    }
}
