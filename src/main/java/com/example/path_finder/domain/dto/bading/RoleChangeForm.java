package com.example.path_finder.domain.dto.bading;

public class RoleChangeForm {

    private String roleName;

    public RoleChangeForm(){

    }

    public String roleName() {
        return roleName;
    }

    public RoleChangeForm setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
}
