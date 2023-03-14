package com.example.path_finder.domain.entities;

import com.example.path_finder.domain.enums.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private Roles role;

    public Roles getRole() {
        return this.role;
    }

    public Role setRole(Roles name) {
        this.role = name;
        return this;
    }
}
