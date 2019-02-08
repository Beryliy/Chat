package com.portfolio.flogiston.chat.model;

public class Message {
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private long date;

    public void setDate(long date) {
        this.date = date;
    }

    public long getDate() {
        return date;
    }
}
