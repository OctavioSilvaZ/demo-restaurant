package com.springboot.restaurant.prototype_demo.app.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.restaurant.prototype_demo.app.dto.ClientRequest;
import com.springboot.restaurant.prototype_demo.app.mappers.ClientProps;
import com.springboot.restaurant.prototype_demo.app.port.in.ClientUseCasePort;
import com.springboot.restaurant.prototype_demo.app.port.out.ClientRepositoryPort;
import com.springboot.restaurant.prototype_demo.domain.entities.Client;

@Service
public class ClientService implements ClientUseCasePort {

    private final ClientRepositoryPort repositoryPort;

    public ClientService(ClientRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Map<String, String> registerClient(ClientRequest client) {
        Client entity = ClientProps.tomapper(client);
        this.repositoryPort.save(entity);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Client registered Successfully");
        return response;
    }

}
