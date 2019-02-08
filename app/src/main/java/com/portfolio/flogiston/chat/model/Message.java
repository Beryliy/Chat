package com.portfolio.flogiston.chat.model;

public class Message {
    private String userName;

    public void setUserId(String userName) {
        this.userName = userName;
    }

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    private long date;

    public void setDate(long date) {
        this.date = date;
    }
}
