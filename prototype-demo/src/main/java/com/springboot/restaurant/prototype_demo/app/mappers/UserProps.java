package com.springboot.restaurant.prototype_demo.app.mappers;

import org.bson.types.ObjectId;
import com.springboot.restaurant.prototype_demo.app.dto.UserRequest;
import com.springboot.restaurant.prototype_demo.domain.entities.User;
import com.springboot.restaurant.prototype_demo.interfaces.controllers.enums.Roles;

public class UserProps {

    public static User tomapper(UserRequest userDto) {
        return new User(
                new ObjectId().toString(), userDto.getName(),
                userDto.getEmail(), userDto.getPassword(), Roles.ROLE_ADMIN.name());

    }
}
