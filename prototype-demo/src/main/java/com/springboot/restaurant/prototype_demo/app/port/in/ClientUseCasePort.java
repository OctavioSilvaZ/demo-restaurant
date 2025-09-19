package com.springboot.restaurant.prototype_demo.app.port.in;

import com.springboot.restaurant.prototype_demo.app.dto.ClientRequest;

public interface ClientUseCasePort {

    void registerClient(ClientRequest client);

}
