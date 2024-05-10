package com.example.chatbotapp;

import java.util.List;

public class ApiRequest {
    private String userMessage;
    private List<ChatEntry> chatHistory;

    public ApiRequest(String userMessage, List<ChatEntry> chatHistory){
        this.userMessage = userMessage;
        this.chatHistory = chatHistory;
    }
    // Getters and setters
    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public List<ChatEntry> getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(List<ChatEntry> chatHistory) {
        this.chatHistory = chatHistory;
    }

}
