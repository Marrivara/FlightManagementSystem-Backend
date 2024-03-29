package com.company.organization.backend.controllers.auth;

import com.company.organization.backend.requests.authRequests.AuthenticationRequest;
import com.company.organization.backend.requests.authRequests.RegisterRequest;
import com.company.organization.backend.response.authResponses.AuthenticationResponse;
import com.company.organization.backend.services.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ) {
        return ResponseEntity
                .ok(authenticationService
                        .register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest registerRequest
    ) {
        return ResponseEntity
                .ok(authenticationService
                        .login(registerRequest));
    }
}
