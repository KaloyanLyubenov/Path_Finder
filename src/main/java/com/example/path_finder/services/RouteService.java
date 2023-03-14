package com.example.path_finder.services;

import com.example.path_finder.domain.dto.view.RouteViewDTO;
import com.example.path_finder.domain.entities.Route;
import com.example.path_finder.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public RouteViewDTO getMostCommented(){
        return RouteViewDTO.fromRoute(this.routeRepository.
                findMostCommented().
                orElseThrow(NoSuchElementException::new).
                get(0));
    }

}
