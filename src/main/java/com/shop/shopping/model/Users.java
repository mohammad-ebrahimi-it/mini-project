package com.shop.shopping.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String cover;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "users")

    private Set<Posts> posts = new HashSet<>();

    public static class UserBuilder {

        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String username;
        private String password;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private String cover;


        private Set<Posts> posts = new HashSet<>();
        private Collection<Role> roles = new ArrayList<>();


        private UserBuilder() {
        }

        public static UserBuilder builder() {
            return new UserBuilder();
        }

        public UserBuilder setId(Long id) {
            this.id = id;
            return this;
        }
        public UserBuilder setUserName(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setCover(String cover) {
            this.cover = cover;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setPost(Set<Posts> posts) {
            this.posts = posts;
            return this;
        }
        public UserBuilder setRoles(Collection<Role> roles) {
            this.roles = roles;
            return this;
        }

        public UserBuilder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }
         public UserBuilder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Users build() {
            return new Users(id,  firstName,  lastName,  username,  email,  password,  cover,  createdAt,  updatedAt,  roles, posts);
        }


    }
}

