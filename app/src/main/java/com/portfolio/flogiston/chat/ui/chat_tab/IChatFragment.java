package com.portfolio.flogiston.chat.ui.chat_tab;

import android.widget.EditText;

import com.portfolio.flogiston.chat.model.Message;

public interface IChatFragment {
    void addData(Message message);
    EditText getEditText();
    void handleSendingError(String errorMessage);
}
