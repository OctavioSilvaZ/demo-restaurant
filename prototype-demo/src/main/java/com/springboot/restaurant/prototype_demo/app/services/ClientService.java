package com.springboot.restaurant.prototype_demo.app.services;

import org.springframework.stereotype.Service;

import com.springboot.restaurant.prototype_demo.app.dto.ClientRequest;
import com.springboot.restaurant.prototype_demo.app.mappers.ClientProps;
import com.springboot.restaurant.prototype_demo.app.port.in.ClientUseCasePort;
import com.springboot.restaurant.prototype_demo.infraestructure.persistencie.ClientRepositoryAdapter;
import com.springboot.restaurant.prototype_demo.domain.entities.Client;

@Service
public class ClientService implements ClientUseCasePort {

    private final ClientRepositoryAdapter repositoryAdapter;

    public ClientService(ClientRepositoryAdapter repositoryAdapter) {
        this.repositoryAdapter = repositoryAdapter;
    }

    @Override
    public void registerClient(ClientRequest client) {
        Client entity = ClientProps.tomapper(client);
        this.repositoryAdapter.save(entity);
    }

}
