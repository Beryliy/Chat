package com.portfolio.flogiston.chat.tabs.chat;

import android.widget.EditText;

import com.portfolio.flogiston.chat.model.Message;
import com.portfolio.flogiston.chat.ui.chat_tab.IChatFragment;

public class ChatPresenter implements IChatPresenter, ChatModel.OnDataChanged {
    private IChatFragment fragment;
    private IChatModel model;

    public ChatPresenter(IChatFragment fragment){
        this.fragment = fragment;
        this.model = new ChatModel(this);
        model.readMessages();
    }

    @Override
    public void onMessageLoad(Message message) {
        fragment.addData(message);
    }

    @Override
    public void onMessageSaved() {
        fragment.getEditText().setText("");
    }

    @Override
    public void onError(String errorMessage) {
        fragment.handleSendingError(errorMessage);
    }

    @Override
    public void sendMessage() {
        Message message = new Message();
        EditText messageEditText = fragment.getEditText();
        message.setMessage(messageEditText.getText().toString());
        //TODO: receive user and set his name to message
        message.setUserName("username");
        message.setDate(System.currentTimeMillis());
        model.saveMessage(message);
    }
}
