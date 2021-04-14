package com.hackaton.bbva.controller;

import com.hackaton.bbva.model.entity.User;
import com.hackaton.bbva.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<User> getActualUser() {
        return ResponseEntity.ok(userService.getUserWithAuthorities().get());
    }
}