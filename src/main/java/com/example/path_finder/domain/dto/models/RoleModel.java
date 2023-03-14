package com.example.path_finder.domain.dto.models;

import com.example.path_finder.domain.enums.Roles;

public class RoleModel {

    private Long id;
    private Roles role;

    public RoleModel() {
    }

    public long getId() {
        return id;
    }

    public RoleModel setId(long id) {
        this.id = id;
        return this;
    }

    public Roles getRole() {
        return role;
    }

    public RoleModel setRole(Roles role) {
        this.role = role;
        return this;
    }
}
