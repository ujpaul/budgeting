package com.budgeting.burdgetmanagement.exception;

public class TokenNotFoundException extends Throwable {
    private String message;

    public TokenNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
