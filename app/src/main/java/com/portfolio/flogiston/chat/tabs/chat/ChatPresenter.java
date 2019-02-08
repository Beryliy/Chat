package com.portfolio.flogiston.chat.tabs.chat;

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
}
