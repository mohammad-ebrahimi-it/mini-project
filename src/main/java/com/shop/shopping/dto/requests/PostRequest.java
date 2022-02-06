package com.shop.shopping.dto.requests;

import com.shop.shopping.model.Categoreis;
import com.shop.shopping.model.Users;

import java.util.HashSet;
import java.util.Set;

public class PostRequest {
    private String title;
    private String cover;

    private Users users;
    private Set<Categoreis> categoreis = new HashSet<>();

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Categoreis> getCategoreis() {
        return categoreis;
    }

    public void setCategoreis(Set<Categoreis> categoreis) {
        this.categoreis = categoreis;
    }
}
