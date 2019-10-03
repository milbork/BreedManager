package com.breedmanager.entitis;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String message;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "sender")
    private User sender;

    private Long recipientsID;

    public Message() {
    }

    public Message(String message, User sender, Long recipientsID) {
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
