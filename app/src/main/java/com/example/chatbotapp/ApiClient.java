package com.example.chatbotapp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static ApiService getClient() {
        if (retrofit == null) {
            // Create OkHttpClient with logging interceptor
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY); // Set log level as needed
            httpClientBuilder.addInterceptor(loggingInterceptor);

            // Build Retrofit instance with OkHttpClient and base URL
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:5000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClientBuilder.build()) // Use OkHttpClient with logging interceptor
                    .build();
        }
        return retrofit.create(ApiService.class);
    }
}

