package com.example.path_finder.domain.dto.bading;

public class UserLoginForm {

    private String username;
    private String password;

    public UserLoginForm() {
    }

    public String username() {
        return username;
    }

    public UserLoginForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public String password() {
        return password;
    }

    public UserLoginForm setPassword(String password) {
        this.password = password;
        return this;
    }
}
