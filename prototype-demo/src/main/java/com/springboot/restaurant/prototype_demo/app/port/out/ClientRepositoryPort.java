package com.springboot.restaurant.prototype_demo.app.port.out;

import org.bson.types.ObjectId;

import com.springboot.restaurant.prototype_demo.domain.entities.Client;

public interface ClientRepositoryPort {

    Client findById(ObjectId id);

    void save(Client clients
    );
}
