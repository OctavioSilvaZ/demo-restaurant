package com.springboot.restaurant.prototype_demo.app.port.in;

import java.util.List;
import java.util.Map;

import com.springboot.restaurant.prototype_demo.app.dto.UserRequest;
import com.springboot.restaurant.prototype_demo.domain.entities.User;
import com.springboot.restaurant.prototype_demo.security.dto.AuthResponse;
import com.springboot.restaurant.prototype_demo.security.schemas.AuthRequest;

public interface UserUseCasePort {

    AuthResponse login(AuthRequest authRequest);

    Map<String, String> registerUser(UserRequest user);

    List<User> getAllUsers();

}
