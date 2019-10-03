package com.breedmanager.entitis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private User sender;
    private User recipient;
    private String message;

    public Message() {
    }

    public Message(User sender, User recipient, String message) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getSender(){
        return this.sender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
