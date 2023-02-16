package com.zeran.ticket.service;

import com.zeran.ticket.request.AuthenticationRequest;
import com.zeran.ticket.request.RegisterRequest;
import com.zeran.ticket.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest registerReq);

    AuthenticationResponse authenticate(AuthenticationRequest authReq);
}
