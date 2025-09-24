package com.springboot.restaurant.prototype_demo.infraestructure.persistencie;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.springboot.restaurant.prototype_demo.app.port.out.UserRepositoryPort;
import com.springboot.restaurant.prototype_demo.domain.entities.User;
import com.springboot.restaurant.prototype_demo.infraestructure.mappers.UserMapper;
import com.springboot.restaurant.prototype_demo.infraestructure.repositories.SpringUserRepository;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final SpringUserRepository springUserRepository;

    public UserRepositoryAdapter(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Override
    public User findById(String id) {
        return springUserRepository.findById(id)
                .map(UserMapper::fromPersistence)
                .orElse(null);

    }

    @Override
    public void save(User user) {
        this.springUserRepository.save(UserMapper.toPersistence(user));

    }

    @Override
    public List<User> findAll() {
        return springUserRepository.findAll().stream()
                .map(UserMapper::fromPersistence)
                .toList();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springUserRepository.findByEmail(email)
                .map(UserMapper::fromPersistence);
    }

}
