package com.example.path_finder.web;

import com.example.path_finder.domain.dto.view.RouteViewDTO;
import com.example.path_finder.services.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController{
    private final RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public ModelAndView getHome(ModelAndView modelAndView){
        final RouteViewDTO mostCommented = routeService.getMostCommented();
        modelAndView.addObject("mostCommented", mostCommented);
        return super.view("index", modelAndView);
    }


}
