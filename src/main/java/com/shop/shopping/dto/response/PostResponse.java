package com.shop.shopping.dto.response;

import com.shop.shopping.model.category.Categories;
import com.shop.shopping.model.user.Users;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @class PostResponse
 */
public class PostResponse {

    private Long id;
    private String title;
    private String cover;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdateAt;

    private Users users;
    private Set<Categories> categoreis = new HashSet<>();

    public PostResponse() {
    }

    public PostResponse(Long id, String title, String cover, LocalDateTime createdAt,
                        LocalDateTime updateAt, Users users, Set<Categories> categoreis) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        CreatedAt = createdAt;
        UpdateAt = updateAt;
        this.users = users;
        this.categoreis = categoreis;
    }

    /**
     *
     * @return id
     *
     */
    public Long getId() {
        return id;
    }

    /**
     * @void
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        UpdateAt = updateAt;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Categories> getCategoreis() {
        return categoreis;
    }

    public void setCategoreis(Set<Categories> categoreis) {
        this.categoreis = categoreis;
    }

    public static class PostResponseBuilder{

        private Long id;
        private String title;
        private String cover;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private Users users;
        private Set<Categories> categoreis = new HashSet<>();

        private PostResponseBuilder() {}

        public PostResponseBuilder builder() {
            return new PostResponseBuilder();
        }

        public PostResponseBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PostResponseBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public PostResponseBuilder setCover(String cover) {
            this.cover = cover;
            return this;
        }

        public PostResponseBuilder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PostResponseBuilder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public PostResponseBuilder setUser(Users users) {
            this.users = users;
            return this;
        }

        public PostResponseBuilder setCategory (Set<Categories> categoreis) {
            this.categoreis =  categoreis;
            return this;
        }

        public PostResponse build(){
            return new PostResponse(id, title, cover, createdAt, updatedAt, users, categoreis);
        }

    }
}
