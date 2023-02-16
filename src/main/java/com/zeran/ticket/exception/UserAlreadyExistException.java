package com.zeran.ticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User exists!")
public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
