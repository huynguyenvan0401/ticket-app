package com.zeran.ticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceExistException extends RuntimeException {

    public ResourceExistException(String message) {
        super(message);
    }
}
