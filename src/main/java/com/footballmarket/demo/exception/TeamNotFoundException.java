package com.footballmarket.demo.exception;

public class TeamNotFoundException extends DynamicConfigurationApiException {

    private static final long serialVersionUID = 4034380266811157662L;

    public TeamNotFoundException(String message) {
        super(message);
    }

    public TeamNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
