package com.springboot.restaurant.prototype_demo.infraestructure.mappers;

import com.springboot.restaurant.prototype_demo.domain.entities.Client;
import com.springboot.restaurant.prototype_demo.infraestructure.shemas.ClientSchema;

public class ClientMapper {

    public static ClientSchema toPersistence(Client entity) {
        return new ClientSchema(entity.name(), entity.email());
    }

    public static Client fromPersistence(ClientSchema doc) {
        return new Client(doc.getId(), doc.getNombre(), doc.getEmail());
    }
}
