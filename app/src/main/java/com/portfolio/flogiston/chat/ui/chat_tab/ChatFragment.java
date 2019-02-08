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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.portfolio.flogiston.chat.R;
import com.portfolio.flogiston.chat.model.Message;
import com.portfolio.flogiston.chat.tabs.chat.ChatPresenter;
import com.portfolio.flogiston.chat.tabs.chat.IChatPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatFragment extends Fragment implements IChatFragment{
    private IChatPresenter presenter;
    ChatAdapter chatAdapter = new ChatAdapter();
    @BindView(R.id.messages_list) RecyclerView messagesList;
    @BindView(R.id.message_edit_text) EditText messageEditText;
    @BindView(R.id.send_button) Button sendButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        this.presenter = new ChatPresenter(this);
        messagesList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        messagesList.setLayoutManager(layoutManager);
        messagesList.setAdapter(chatAdapter);
        return view;
    }

    @OnClick(R.id.send_button)
    public void sendButtonClicked(){
        presenter.sendMessage();
    }

    @Override
    public void addData(Message message) {//replace single message by List
        chatAdapter.add(message);
        chatAdapter.notifyDataSetChanged();
    }

    @Override
    public EditText getEditText() {
        return messageEditText;
    }

}
