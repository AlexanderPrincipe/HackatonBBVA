package com.hackaton.bbva.service.impl;

import com.hackaton.bbva.model.request.UserRq;
import com.hackaton.bbva.repository.UserRepository;
import com.hackaton.bbva.security.SecurityUtils;
import com.hackaton.bbva.model.entity.User;
import com.hackaton.bbva.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities() {
        return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }

    @Override
    public User saveUser(UserRq userRq) {

        return userRepository.save(userRq.getUser());
    }
}