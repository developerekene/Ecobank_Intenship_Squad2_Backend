package com.backend.InternHub.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EtAuthException extends RuntimeException{
    public EtAuthException(String message) {
        super(message);
    }
}
