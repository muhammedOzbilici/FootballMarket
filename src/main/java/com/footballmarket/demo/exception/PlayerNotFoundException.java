package com.footballmarket.demo.exception;

public class PlayerNotFoundException extends DynamicConfigurationApiException {

    private static final long serialVersionUID = 4034380266845157662L;

    public PlayerNotFoundException(String message) {
        super(message);
    }

    public PlayerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
