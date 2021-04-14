package com.hackaton.bbva.service;

import com.hackaton.bbva.model.entity.User;
import com.hackaton.bbva.model.request.UserRq;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserWithAuthorities();

    User saveUser(UserRq userRq);
}