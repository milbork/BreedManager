package com.breedmanager.DTO;

import com.breedmanager.entitis.Breeding;
import com.breedmanager.entitis.Message;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class UserDTO {
    private Long id;
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;
    @NotBlank
    @Size(min = 2, max = 30)
    private String password;
    @NotBlank
    @Email
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @NotNull
    private String function;
    private Breeding breeding;

    private List<Message> sentMessages;
    private List<Message> receivedMessages;

    public UserDTO() {
    }

    public UserDTO(@NotBlank @Email String email) {
        this.email = email;
    }

    public UserDTO(Long id, @NotBlank @Size(min = 2, max = 30) String firstName, @NotBlank @Size(min = 2, max = 30) String lastName, @NotBlank @Size(min = 2, max = 30) String password, @NotBlank @Email String email, @NotNull String function,
                   Breeding breeding, List<Message> sentMessages, List<Message> receivedMessages) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.function = function;
        this.breeding = breeding;
        this.sentMessages = sentMessages;
        this.receivedMessages = receivedMessages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Breeding getBreeding() {
        return breeding;
    }

    public void setBreeding(Breeding breeding) {
        this.breeding = breeding;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }
}
