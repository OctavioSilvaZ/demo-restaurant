package com.springboot.restaurant.prototype_demo.app.port.in;

import java.util.Map;

import com.springboot.restaurant.prototype_demo.app.dto.ClientRequest;

public interface ClientUseCasePort {

    Map<String, String> registerClient(ClientRequest client);

}
