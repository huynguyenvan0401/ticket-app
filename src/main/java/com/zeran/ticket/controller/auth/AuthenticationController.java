package com.zeran.ticket.controller.auth;

import com.zeran.ticket.exception.BadRequestException;
import com.zeran.ticket.request.AuthenticationRequest;
import com.zeran.ticket.request.RegisterRequest;
import com.zeran.ticket.response.AuthenticationResponse;
import com.zeran.ticket.service.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerReq) {
        return ResponseEntity.ok(authenticationService.register(registerReq));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest authReq, HttpServletResponse response) {
        try {
            return ResponseEntity.ok(authenticationService.authenticate(authReq));
        }
        catch (BadCredentialsException exc) {
            throw new BadRequestException("Sai tên đăng nhập hoặc mật khẩu!");
        }
        catch (Exception e) {
            throw new BadRequestException("Phát sinh lỗi trong quá trình xác thực!");
        }

    }
}
