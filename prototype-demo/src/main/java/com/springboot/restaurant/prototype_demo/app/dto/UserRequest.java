package com.springboot.restaurant.prototype_demo.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank(message = "Name is empty")
    private String name;

    @Email(message = "Email Invalid")
    @NotBlank(message = "Email is empty")
    private String email;

    @NotBlank(message = "Password is empty")
    private String password;

    public UserRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
