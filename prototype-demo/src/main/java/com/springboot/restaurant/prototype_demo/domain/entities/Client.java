package com.springboot.restaurant.prototype_demo.domain.entities;

import org.bson.types.ObjectId;

public record Client(
        ObjectId id,
        String name,
        String email
        ) {

}
