package com.portfolio.flogiston.chat.ui.chat_tab;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.portfolio.flogiston.chat.R;
import com.portfolio.flogiston.chat.model.Message;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private List<Message> messages;
    ChatAdapter(){
        messages = new ArrayList<Message>();
    }

    public void add(Message message){
        messages.add(message);
    }



    static class ChatViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.user_name)
        TextView userNameTextView;
        @BindView(R.id.message_body) TextView messageBodyTextView;
        @BindView(R.id.sending_date) TextView sendingDateTextView;

        public ChatViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View messageListSimpleItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_list_item, parent, false);
        return new ChatViewHolder(messageListSimpleItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.userNameTextView.setText(message.getUserName());
        holder.messageBodyTextView.setText(message.getMessage());
        //TODO: cast time to String format
        holder.sendingDateTextView.setText(String.valueOf(message.getDate()));
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

}