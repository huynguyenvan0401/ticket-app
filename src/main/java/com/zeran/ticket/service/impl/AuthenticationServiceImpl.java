package com.zeran.ticket.service.impl;

import com.zeran.ticket.entity.Role;
import com.zeran.ticket.entity.User;
import com.zeran.ticket.exception.BadRequestException;
import com.zeran.ticket.exception.UserAlreadyExistException;
import com.zeran.ticket.exception.UserNotFoundException;
import com.zeran.ticket.repository.RoleRepository;
import com.zeran.ticket.repository.UserRepository;
import com.zeran.ticket.request.AuthenticationRequest;
import com.zeran.ticket.request.RegisterRequest;
import com.zeran.ticket.response.AuthenticationResponse;
import com.zeran.ticket.service.AuthenticationService;
import com.zeran.ticket.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest registerReq) {
        if (userRepository.findByEmail(registerReq.getEmail()).isPresent()) {
            throw new UserAlreadyExistException("User already exists with email: " + registerReq.getEmail());
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName(Role.USER));
        var user = User.builder()
                .firstName(registerReq.getFirstName())
                .lastName(registerReq.getLastName())
                .email(registerReq.getEmail())
                .password(passwordEncoder.encode(registerReq.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authReq) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authReq.getEmail(),
                        authReq.getPassword()
                )
        );

        var user = userRepository.findByEmail(authReq.getEmail())
                .orElseThrow(() -> new BadRequestException("User không tồn tại!"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .car(user.getCar())
                .roles(user.getRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toSet()))
                .build();
    }
}
