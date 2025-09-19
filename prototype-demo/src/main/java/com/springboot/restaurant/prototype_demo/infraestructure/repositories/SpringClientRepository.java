package com.springboot.restaurant.prototype_demo.infraestructure.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.restaurant.prototype_demo.infraestructure.shemas.ClientSchema;

public interface SpringClientRepository extends MongoRepository<ClientSchema, ObjectId> {

}
