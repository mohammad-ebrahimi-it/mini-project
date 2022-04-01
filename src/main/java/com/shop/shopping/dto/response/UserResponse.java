package com.shop.shopping.dto.response;

import com.shop.shopping.model.post.Posts;

import java.util.HashSet;
import java.util.Set;

public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String cover;


    private Set<Posts> posts = new HashSet<>();

    public UserResponse(String firstName, String lastName, String email, String cover, Set<Posts> posts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cover = cover;
        this.posts = posts;
    }

    public UserResponse() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Set<Posts> getPosts() {
        return posts;
    }

    public void setPosts(Set<Posts> posts) {
        this.posts = posts;
    }

    public static class UserResponseBuilder{

        private String firstName;
        private String lastName;
        private String email;
        private String cover;


        private Set<Posts> posts = new HashSet<>();

        private UserResponseBuilder(){}

        public static UserResponseBuilder builder() {
            return new UserResponseBuilder();
        }
        public UserResponseBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserResponseBuilder setLastName (String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserResponseBuilder setEmail (String email) {
            this.email = email;
            return this;
        }

        public UserResponseBuilder setCover (String cover) {
            this.cover = cover;
            return this;
        }

        public UserResponseBuilder setPosts (Set<Posts> posts) {
            this.posts = posts;
            return this;
        }

        public UserResponse build() {
            return new UserResponse(firstName, lastName, email, cover, posts);
        }
    }
}

