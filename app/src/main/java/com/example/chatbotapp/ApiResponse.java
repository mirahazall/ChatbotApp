package com.example.chatbotapp;

public class ApiResponse {
    private String message;

    public ApiResponse(String message) {
        this.message = message;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

