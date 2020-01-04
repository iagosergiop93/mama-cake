package com.cake.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private HttpStatus status;

    public CustomException() {
        super();
        this.status = HttpStatus.I_AM_A_TEAPOT;
    }

    public CustomException(String msg) {
        super(msg);
        this.status = HttpStatus.I_AM_A_TEAPOT;
    }

    public CustomException(String msg, HttpStatus status) {
        super(msg);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
