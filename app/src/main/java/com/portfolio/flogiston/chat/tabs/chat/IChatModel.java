package com.portfolio.flogiston.chat.tabs.chat;

import com.portfolio.flogiston.chat.model.Message;

public interface IChatModel {
    void saveMessage(Message message);
    void readMessages();
}
