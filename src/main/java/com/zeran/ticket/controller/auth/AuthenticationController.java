package com.zeran.ticket.controller.auth;

import com.zeran.ticket.request.AuthenticationRequest;
import com.zeran.ticket.request.RegisterRequest;
import com.zeran.ticket.response.AuthenticationResponse;
import com.zeran.ticket.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerReq) {
        return ResponseEntity.ok(authenticationService.register(registerReq));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest authReq) {

        return ResponseEntity.ok(authenticationService.authenticate(authReq));
    }
}
