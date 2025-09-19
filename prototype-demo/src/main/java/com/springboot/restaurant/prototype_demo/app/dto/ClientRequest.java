package com.springboot.restaurant.prototype_demo.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClientRequest {

    @NotBlank(message = "Name is empty")
    private String name;

    @Email(message = "Email Invalid")
    @NotBlank(message = "Email is empty")
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Constructor completo
    public ClientRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
