package org.aviasales.service.impl;

import org.aviasales.configuration.security.JwtProvider;
import org.aviasales.dto.AuthenticationRequest;
import org.aviasales.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtUtils;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtProvider jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public String authenticateUser(AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );
        // return hashmap with bearer plus token instead of only token
        return jwtUtils.generateToken(authentication);
    }
}
