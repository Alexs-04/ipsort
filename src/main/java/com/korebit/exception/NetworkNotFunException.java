package com.korebit.exception;

public class NetworkNotFunException extends RuntimeException {
    public NetworkNotFunException(String message) {
        super(message);
    }

    public NetworkNotFunException(String message, Throwable cause) {
        super(message, cause);
    }
}
