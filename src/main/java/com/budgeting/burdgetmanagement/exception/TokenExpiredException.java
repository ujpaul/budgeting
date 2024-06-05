package com.budgeting.burdgetmanagement.exception;

public class TokenExpiredException extends Throwable {
    private String message;

    public TokenExpiredException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
