package com.springboot.restaurant.prototype_demo.infraestructure.mappers;

import com.springboot.restaurant.prototype_demo.domain.entities.User;
import com.springboot.restaurant.prototype_demo.infraestructure.schemas.UserSchema;

public class UserMapper {

    public static UserSchema toPersistence(User entity) {
        return new UserSchema(entity.name(), entity.email(), entity.password(), entity.role());
    }

    public static User fromPersistence(UserSchema doc) {
        return new User(doc.getId(), doc.getName(), doc.getEmail(), doc.getPassword(), doc.getRole());
    }

}
