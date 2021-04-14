package com.hackaton.bbva.controller;

import com.hackaton.bbva.model.dto.JWTToken;
import com.hackaton.bbva.model.dto.LoginDto;
import com.hackaton.bbva.model.response.GeneralResponse;
import com.hackaton.bbva.security.jwt.JWTFilter;
import com.hackaton.bbva.security.jwt.TokenProvider;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/authenticate")
public class AuthenticationRestController {

    private final TokenProvider tokenProvider;
    private final Environment environment;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthenticationRestController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, Environment environment) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.environment = environment;
    }

    @PostMapping
    public ResponseEntity<GeneralResponse<JWTToken>> authorize(@Valid @RequestBody LoginDto loginDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        boolean rememberMe = loginDto.getRememberMe() != null && loginDto.getRememberMe();

        Long now = (new Date()).getTime();
        Long expiresAt;
        Long tokenValidityInMilliseconds = environment.getProperty("jwt.token-validity-in-seconds", Long.class) * 1000;
        Long tokenValidityInMillisecondsForRememberMe = environment.getProperty("jwt.token-validity-in-seconds-for-remember-me", Long.class) * 1000;

        if (rememberMe) {
            expiresAt = now + tokenValidityInMillisecondsForRememberMe;
        } else {
            expiresAt = now + tokenValidityInMilliseconds;
        }

        String jwt = tokenProvider.createToken(authentication, expiresAt);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        String username = loginDto.getUsername();
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        GeneralResponse<JWTToken> response = new GeneralResponse<>();
        response.setData(new JWTToken(username, jwt, expiresAt, roles));
        return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
    }
}