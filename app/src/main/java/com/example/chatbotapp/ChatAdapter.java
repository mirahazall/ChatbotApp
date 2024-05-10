package com.example.chatbotapp;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MessageViewHolder> {

    private List<ChatEntry> chatHistory;
    private Context context;

    public ChatAdapter(Context context, List<ChatEntry> chatHistory) {
        this.context = context;
        this.chatHistory = chatHistory;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chat_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        ChatEntry chatEntry = chatHistory.get(position);
        holder.bind(chatEntry);
    }

    @Override
    public int getItemCount() {
        return chatHistory.size();
    }


    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewU;
        private TextView textViewUserQuestion;
        private ImageView imageViewAi2;
        private TextView textViewWAiRespond;
        private LinearLayout messageContainer;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewU = itemView.findViewById(R.id.textViewU);
            textViewUserQuestion = itemView.findViewById(R.id.textViewUserQuestion);
            imageViewAi2 = itemView.findViewById(R.id.imageViewAi2);
            textViewWAiRespond = itemView.findViewById(R.id.textViewWAiRespond);
        }

        public void bind(ChatEntry chatEntry) {
                // If message is from user, show user question and hide chatbot response
                textViewUserQuestion.setText(chatEntry.getUser());

                // If message is from chatbot, show chatbot response and hide user question
                textViewWAiRespond.setText(chatEntry.getLlama());

        }
    }
}

