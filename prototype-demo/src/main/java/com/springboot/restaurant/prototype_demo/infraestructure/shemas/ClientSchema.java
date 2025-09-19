package com.springboot.restaurant.prototype_demo.infraestructure.shemas;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "clients")
public class ClientSchema {

    @Id
    private ObjectId id;
    private String nombre;
    private String email;
    @Field("time_stamp")
    private Instant timeStamp;

    public ClientSchema(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.timeStamp = Instant.now();
    }

    public ObjectId getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

}
