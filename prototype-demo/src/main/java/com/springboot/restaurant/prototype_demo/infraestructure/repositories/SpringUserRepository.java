package com.springboot.restaurant.prototype_demo.infraestructure.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.restaurant.prototype_demo.infraestructure.schemas.UserSchema;

public interface SpringUserRepository extends MongoRepository<UserSchema, String> {

    Optional<UserSchema> findByEmail(String email);

}
