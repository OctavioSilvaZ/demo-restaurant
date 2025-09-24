package com.springboot.restaurant.prototype_demo.interfaces.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.restaurant.prototype_demo.app.dto.UserRequest;
import com.springboot.restaurant.prototype_demo.app.port.in.UserUseCasePort;
import com.springboot.restaurant.prototype_demo.domain.entities.User;
import com.springboot.restaurant.prototype_demo.security.dto.AuthResponse;
import com.springboot.restaurant.prototype_demo.security.schemas.AuthRequest;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCasePort userUseCasePort;

    @PostMapping("/login")
    public AuthResponse logIn(@RequestBody AuthRequest authRequest) {
        return this.userUseCasePort.login(authRequest);
    }

    @PostMapping("/register-user")
    public Map<String, String> registerUser(@RequestBody UserRequest userDto) {
        return this.userUseCasePort.registerUser(userDto);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return this.userUseCasePort.getAllUsers();
    }

}
