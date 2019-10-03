package com.breedmanager.DTO;

import com.breedmanager.entitis.User;

public class MessageDTO {
    private Long id;
    private User sender;
    private Long recipientsID;
    private String message;

    public MessageDTO() {
    }

    public MessageDTO(String message, User sender, Long recipientsID) {
        this.message = message;
        this.sender = sender;
        this.recipientsID = recipientsID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Long getRecipientsID() {
        return recipientsID;
    }

    public void setRecipientsID(Long recipientsID) {
        this.recipientsID = recipientsID;
    }
}
