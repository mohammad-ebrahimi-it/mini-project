package com.shop.shopping.model.category;

import com.shop.shopping.model.post.Posts;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class CategoryBuilder {

        private Long id;
        private String title;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Set<Posts> posts = new HashSet<>();

        private CategoryBuilder() {
        }

        public static CategoryBuilder categoryBuilder() {
            return new CategoryBuilder();
        }

        public CategoryBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public CategoryBuilder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CategoryBuilder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public CategoryBuilder setPosts(Set<Posts> posts) {
            this.posts = posts;
            return this;
        }

        public Categories build() {
            return new Categories(id, title, createdAt, updatedAt, posts);
        }



}
