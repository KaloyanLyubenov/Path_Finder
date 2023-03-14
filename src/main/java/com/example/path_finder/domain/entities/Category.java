package com.example.path_finder.domain.entities;

import com.example.path_finder.domain.enums.Categories;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private Categories name;

    @Column(columnDefinition = "LONGTEXT")
    private String description;


    public Categories getName() {
        return this.name;
    }

    public Category setName(Categories name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
