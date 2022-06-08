package dev.landen.utils.exceptions;

public class UserNameTakenException extends RuntimeException  {

    public UserNameTakenException() {
    }

    public UserNameTakenException(String message) {
        super(message);
    }

    public UserNameTakenException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameTakenException(Throwable cause) {
        super(cause);
    }

    public UserNameTakenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
