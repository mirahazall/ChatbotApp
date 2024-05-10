package com.example.chatbotapp;

public class ChatEntry {
    private String User;
    private String Llama;

    public ChatEntry(String userMessage, String chatBotResponse) {
        this.User = userMessage;
        this.Llama = chatBotResponse;
    }

    // Getters and setters
    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        this.User = user;
    }

    public String getLlama() {
        return Llama;
    }

    public void setLlama(String llama) {
        this.Llama = llama;
    }
}

