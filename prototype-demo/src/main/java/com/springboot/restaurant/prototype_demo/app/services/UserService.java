package com.springboot.restaurant.prototype_demo.app.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.restaurant.prototype_demo.app.dto.UserRequest;
import com.springboot.restaurant.prototype_demo.app.mappers.UserProps;
import com.springboot.restaurant.prototype_demo.app.port.in.UserUseCasePort;
import com.springboot.restaurant.prototype_demo.app.port.out.UserRepositoryPort;
import com.springboot.restaurant.prototype_demo.domain.entities.User;
import com.springboot.restaurant.prototype_demo.security.dto.AuthResponse;
import com.springboot.restaurant.prototype_demo.security.schemas.AuthRequest;
import com.springboot.restaurant.prototype_demo.security.services.JWTService;
import com.springboot.restaurant.prototype_demo.security.services.UserInfoDetails;

@Service
public class UserService implements UserDetailsService, UserUseCasePort {

    private final UserRepositoryPort repositoryPort;

    private final PasswordEncoder encoder;

    private final JWTService jwtService;

    private final AuthenticationManager authenticationManager;

    public UserService(UserRepositoryPort repositoryPort, PasswordEncoder encoder, JWTService jwtService, @org.springframework.context.annotation.Lazy AuthenticationManager authenticationManager) {
        this.encoder = encoder;
        this.repositoryPort = repositoryPort;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userDetails = this.repositoryPort.findByEmail(email);
        return userDetails.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );
        if (authentication.isAuthenticated()) {
            String jwt = jwtService.generateToke(authRequest.getEmail());
            return new AuthResponse(authRequest.getEmail(), jwt);
        } else {
            throw new UsernameNotFoundException("Invalid user");
        }
    }

    @Override
    public Map<String, String> registerUser(UserRequest user) {
        user.setPassword(encoder.encode(user.getPassword()));
        User entity = UserProps.tomapper(user);
        this.repositoryPort.save(entity);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered Successfully");
        return response;
    }

    @Override
    public List<User> getAllUsers() {
        return this.repositoryPort.findAll();
    }
}
