package com.shop.shopping.model.post;

import com.shop.shopping.model.user.Users;
import com.shop.shopping.model.category.Categories;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class PostBuilder {

    private Long id;
    private String title;
    private String cover;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Users user;
    private Set<Categories> categories = new HashSet<>();



    private PostBuilder(){}

    public static PostBuilder postBuilder () {
        return new PostBuilder();
    }

    public PostBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PostBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public PostBuilder setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public PostBuilder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public PostBuilder setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public PostBuilder setUser(Users user) {
        this.user = user;
        return this;
    }

    public PostBuilder setCategories(Set<Categories> categories) {
        this.categories = categories;
        return this;
    }

    public Posts build() {
        return new Posts(id, title, cover,createdAt, updatedAt, user,categories);
    }
}
