package com.app.todo.payload.response;

public class MessageResponse {

    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }
    public String getmessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
