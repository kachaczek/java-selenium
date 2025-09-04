package com.example.greetings;

// NyObject class is used for creating JSON message
public class MyObject {
    private String message;
    private boolean success;

    public MyObject(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
