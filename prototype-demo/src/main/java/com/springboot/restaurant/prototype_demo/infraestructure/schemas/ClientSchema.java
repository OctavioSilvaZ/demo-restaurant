package com.springboot.restaurant.prototype_demo.infraestructure.schemas;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "clients")
public class ClientSchema {

    @Id
    private String id;
    private String name;
    private String email;
    @Field("time_stamp")
    private Instant timeStamp;

    public ClientSchema(String name, String email) {
        this.name = name;
        this.email = email;
        this.timeStamp = Instant.now();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Instant timeStamp() {
        return timeStamp;
    }

}
