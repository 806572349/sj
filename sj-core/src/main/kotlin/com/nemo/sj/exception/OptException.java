package com.nemo.sj.exception;

public class OptException extends RuntimeException {
    public OptException() {
        super();
    }

    public OptException(String message) {
        super(message);
    }

    public OptException(String message, Throwable cause) {
        super(message, cause);
    }

    public OptException(Throwable cause) {
        super(cause);
    }

    protected OptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
