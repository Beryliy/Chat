package com.portfolio.flogiston.chat.model;

public class Message {
    private long userId;

    public void setUserId(long userId) {
        this.userId = userId;
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
