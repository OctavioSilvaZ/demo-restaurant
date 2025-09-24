package com.springboot.restaurant.prototype_demo.app.port.out;

import java.util.List;
import java.util.Optional;

import com.springboot.restaurant.prototype_demo.domain.entities.User;

public interface UserRepositoryPort {

    User findById(String id);

    List<User> findAll();

    Optional<User> findByEmail(String email);

    void save(User user);
}
