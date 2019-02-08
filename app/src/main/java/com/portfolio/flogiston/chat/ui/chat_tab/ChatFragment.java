package com.portfolio.flogiston.chat.ui.chat_tab;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.portfolio.flogiston.chat.R;
import com.portfolio.flogiston.chat.model.Message;
import com.portfolio.flogiston.chat.tabs.chat.ChatPresenter;
import com.portfolio.flogiston.chat.tabs.chat.IChatPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatFragment extends Fragment implements IChatFragment{
    private IChatPresenter presenter;
    private ChatAdapter chatAdapter = new ChatAdapter();
    @BindView(R.id.messages_list) RecyclerView messagesList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        this.presenter = new ChatPresenter(this);
        messagesList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        messagesList.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void addData(Message message) {//replace single message by List
        chatAdapter.add(message);
        chatAdapter.notifyDataSetChanged();
    }

    private static class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
        private List<Message> messages;
        ChatAdapter(){
            messages = new ArrayList<Message>();
        }

        private void add(Message message){
            messages.add(message);
        }



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
            Message message = messages.get(position);
            holder.userNameTextView.setText(message.getUserName());
            holder.messageBodyTextView.setText(message.getMessage());
            holder.sendingDateTextView.setText(String.valueOf(message.getDate()));
        }

        @Override
        public int getItemCount() {
            return messages.size();
        }

    }

}
