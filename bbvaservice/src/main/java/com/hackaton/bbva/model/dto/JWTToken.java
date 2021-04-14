package com.hackaton.bbva.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JWTToken {
    private String username;
    private String token;
    private Long expiresAt;
    private List<String> roles;
}
