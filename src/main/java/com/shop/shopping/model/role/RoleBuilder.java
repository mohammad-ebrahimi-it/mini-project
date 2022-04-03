package com.shop.shopping.model.role;

public class RoleBuilder {
    private Long id;
    private String name;
    private String persianName;

    private RoleBuilder() {
    }

    public static RoleBuilder builder() {
        return new RoleBuilder();
    }

    public RoleBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public RoleBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public RoleBuilder setPersianName(String persianName) {
        this.persianName = persianName;
        return this;
    }


    public Roles build() {
        return new Roles(id, name, persianName);
    }
}
