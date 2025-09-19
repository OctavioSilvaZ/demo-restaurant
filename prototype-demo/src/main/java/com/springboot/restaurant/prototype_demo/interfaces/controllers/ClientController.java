package com.springboot.restaurant.prototype_demo.interfaces.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restaurant.prototype_demo.app.dto.ClientRequest;
import com.springboot.restaurant.prototype_demo.app.port.in.ClientUseCasePort;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("client")
public class ClientController {

    private final ClientUseCasePort clientUseCasePort;

    public ClientController(ClientUseCasePort clientUseCasePort) {
        this.clientUseCasePort = clientUseCasePort;
    }

    @PostMapping("/register")
    public void postMethodName(@RequestBody @Valid ClientRequest client) {
        this.clientUseCasePort.registerClient(client);
    }

}
