package com.breedmanager.model.DTO;

import com.breedmanager.model.User;

public class MessageDTO {
    private Long id;
    private User sender;
    private User receiver;
    private String message;

    public MessageDTO() {
    }

    public MessageDTO(Long id, User sender, User receiver, String message) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
