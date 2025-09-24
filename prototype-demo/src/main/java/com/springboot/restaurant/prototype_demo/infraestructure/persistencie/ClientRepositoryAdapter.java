package com.springboot.restaurant.prototype_demo.infraestructure.persistencie;

import org.springframework.stereotype.Repository;

import com.springboot.restaurant.prototype_demo.app.port.out.ClientRepositoryPort;
import com.springboot.restaurant.prototype_demo.domain.entities.Client;
import com.springboot.restaurant.prototype_demo.infraestructure.mappers.ClientMapper;
import com.springboot.restaurant.prototype_demo.infraestructure.repositories.SpringClientRepository;

@Repository
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    private final SpringClientRepository springClientRepository;

    public ClientRepositoryAdapter(SpringClientRepository springClientRepository) {
        this.springClientRepository = springClientRepository;
    }

    @Override
    public void save(Client clients) {
        this.springClientRepository.save(ClientMapper.toPersistence(clients));
    }

    @Override
    public Client findById(String id) {
        return springClientRepository.findById(id)
                .map(ClientMapper::fromPersistence)
                .orElse(null);
    }

}
