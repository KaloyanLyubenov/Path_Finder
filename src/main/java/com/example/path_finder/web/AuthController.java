package com.example.path_finder.web;

import com.example.path_finder.domain.dto.bading.UserLoginForm;
import com.example.path_finder.domain.dto.bading.UserRegisterForm;
import com.example.path_finder.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController{

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView, @ModelAttribute UserRegisterForm userRegisterForm){

        modelAndView.addObject("userRegisterInfo", userRegisterForm);
        return super.view("register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView postRegister(@Valid UserRegisterForm userRegisterInfo,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {

            redirectAttributes.
                    addFlashAttribute("org.springframework.validation.BindingResult.userRegisterInfo",
                    bindingResult).
                    addFlashAttribute("userRegisterInfo", userRegisterInfo);

            return super.view("register");
        }

        this.userService.registerUser(userRegisterInfo);

        return super.redirect("login");
    }

    @GetMapping("/login")
    public ModelAndView getLogin() { return super.view("login"); }

    @PostMapping("/login")
    public ModelAndView postLogin(UserLoginForm userLoginInfo){
        return this.userService.loginUser(userLoginInfo).isValid()
                ? super.redirect("/")
                : super.redirect("login");
    }

    @GetMapping("/logout")
    public ModelAndView postLogout() {
        this.userService.logout();
        return super.redirect("/");
    }


}
