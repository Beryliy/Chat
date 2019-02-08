package com.portfolio.flogiston.chat.ui.chat_tab;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.portfolio.flogiston.chat.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    public static class ChatViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.user_name) TextView userNameTextView;
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
        //TODO: add loading message from storage
    }

    @Override
    public int getItemCount() {

        return 0;
    }

}
