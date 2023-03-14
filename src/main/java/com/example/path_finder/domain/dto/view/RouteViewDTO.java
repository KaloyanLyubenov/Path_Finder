package com.example.path_finder.domain.dto.view;

import com.example.path_finder.domain.entities.Route;

import java.util.NoSuchElementException;

public class RouteViewDTO {

    private String name;
    private String description;
    private String url;

    public RouteViewDTO() {
    }

    public RouteViewDTO(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String name() {
        return name;
    }

    public RouteViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String description() {
        return description;
    }

    public RouteViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String url() {
        return url;
    }

    public RouteViewDTO setUrl(String url) {
        this.url = url;
        return this;
    }

    public static RouteViewDTO fromRoute(Route route){
        return new RouteViewDTO(route.getName(),
                route.getDescription(),
                route.getPictures().
                        stream().
                        findFirst().
                        orElseThrow(NoSuchElementException::new).
                        getUrl());
    }
}
