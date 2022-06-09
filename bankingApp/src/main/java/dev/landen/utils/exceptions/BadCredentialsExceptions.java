package dev.landen.utils.exceptions;

public class BadCredentialsExceptions extends RuntimeException {

    public BadCredentialsExceptions() {
    }

    public BadCredentialsExceptions(String message) {
        super("Username and or password incorrect, please try again.");
    }

    public BadCredentialsExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public BadCredentialsExceptions(Throwable cause) {
        super(cause);
    }

    public BadCredentialsExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
