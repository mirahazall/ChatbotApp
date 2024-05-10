package com.example.chatbotapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("chat")
    Call<ApiResponse> sendMessage(@Body ApiRequest request);
}

