package com.hackaton.bbva.controller;

import com.hackaton.bbva.model.entity.User;
import com.hackaton.bbva.model.request.UserRq;
import com.hackaton.bbva.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserRq userRq) {
        return ResponseEntity.ok(userService.saveUser(userRq));
    }
}