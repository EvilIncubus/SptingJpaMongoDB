package org.aviasales.service;

import org.aviasales.dto.AuthenticationRequest;

public interface AuthenticationService {
    String authenticateUser(AuthenticationRequest authenticationRequest);
}
