package com.example.path_finder.domain.dto.bading;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class UserRegisterForm {

    @Size(min = 5, max = 20)
    private String username;

    @Size(min = 5, max = 20)
    private String password;

    @Size(min = 5, max = 20)
    private String confirmPassword;

    @Size(min = 5, max = 20)
    private String fullName;

    @Email
    private String email;

    @Min(value = 0)
    @Max(value = 20)
    private Integer age;

    public UserRegisterForm() {}

    public String getUsername() {
        return username;
    }

    public UserRegisterForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterForm setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterForm setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterForm setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterForm setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
