package com.zeran.ticket.response;

import com.zeran.ticket.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String accessToken;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Car car;
    private Set<String> roles;
}
