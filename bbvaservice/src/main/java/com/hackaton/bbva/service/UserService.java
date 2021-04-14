package com.hackaton.bbva.service;

import com.hackaton.bbva.model.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserWithAuthorities();
}