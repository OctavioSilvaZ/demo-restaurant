package com.springboot.restaurant.prototype_demo.app.port.out;

import com.springboot.restaurant.prototype_demo.domain.entities.Client;

public interface ClientRepositoryPort {

    Client findById(String id);

    void save(Client clients
    );
}
