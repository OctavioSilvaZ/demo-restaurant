package com.springboot.restaurant.prototype_demo.app.mappers;

import org.bson.types.ObjectId;

import com.springboot.restaurant.prototype_demo.app.dto.ClientRequest;
import com.springboot.restaurant.prototype_demo.domain.entities.Client;

public class ClientProps {

    public static Client tomapper(ClientRequest clientDto) {
        return new Client(new ObjectId().toString(), clientDto.getName(), clientDto.getEmail());
    }

}
