package com.springboot.restaurant.prototype_demo.domain.entities;
public record User(
        String id,
        String name,
        String email,
        String password,
        String role
        ) {

}
