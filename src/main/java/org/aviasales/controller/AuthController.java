package org.aviasales.controller;

import org.aviasales.dto.AuthenticationRequest;
import org.aviasales.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/rest/api/auth")
public class AuthController {
    private final AuthenticationService authenticationService;
    private static final Logger logger = Logger.getLogger(AuthController.class.getName());

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            String token = authenticationService.authenticateUser(request);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            logger.info(e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
