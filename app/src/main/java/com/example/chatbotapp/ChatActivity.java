package com.example.chatbotapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;


import com.google.mlkit.nl.smartreply.SmartReply;
import com.google.mlkit.nl.smartreply.SmartReplyGenerator;
import com.google.mlkit.nl.smartreply.SmartReplySuggestion;

import com.google.mlkit.nl.smartreply.TextMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends AppCompatActivity {
    private EditText editTextUserInput;
    private ImageButton sendButton;
    private RecyclerView chatMessagesRecyclerView;
    private ChatAdapter adapter;
    // Conversation history
    List<ChatEntry> chatHistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        editTextUserInput = findViewById(R.id.editTextUserInput);
        chatMessagesRecyclerView = findViewById(R.id.chatMessagesRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        chatMessagesRecyclerView.setLayoutManager(layoutManager);
        // Initialize the list of messages

        // Initialize the adapter
        adapter = new ChatAdapter(this, chatHistory);
        // Set the adapter to the RecyclerView
        chatMessagesRecyclerView.setAdapter(adapter);

        sendButton = findViewById(R.id.buttonSend);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editTextUserInput.getText().toString().trim();
                if (!TextUtils.isEmpty(userInput)) {
                    // Start AsyncTask to generate smart replies
                    sendMessageToApi(userInput);

                    editTextUserInput.setText(""); // Clear the input field
                }
            }
        });
    }

    private void sendMessageToApi(String userMessage) {
        ApiRequest request = new ApiRequest(userMessage, chatHistory);
        ApiService apiService = ApiClient.getClient();
        Call<ApiResponse> call = apiService.sendMessage(request);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    ApiResponse apiResponse = response.body();
                    String message = apiResponse.getMessage();
                    // Add the response message to the conversation history via the adapter
                    chatHistory.add(new ChatEntry(userMessage, message)); // Add the current user message
                    adapter.notifyDataSetChanged();
                } else {
                    // Handle the error response
                    try {
                        String errorBody = response.errorBody().string();
                        // Handle error message
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                // Handle the failure
                Toast.makeText(ChatActivity.this, "Failed to send message. Please try again later.", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }




}