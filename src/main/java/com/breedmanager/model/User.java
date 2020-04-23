package com.breedmanager.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String function;
    private String firstName;
    private String lastName;
    private String password;
    private int enabled;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "breeder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Breeding breeding;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Dog> dogs;

    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private List<Message> sentMessages;
    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY)
    private List<Message> receivedMessages;

    public User() {
    }

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;


    }

    public User(String function, String firstName, String lastName, String password, int enabled, String email, Set<Role> roles, Breeding breeding,
                List<Dog> dogs, List<Message> sentMessages, List<Message> receivedMessages) {
        this.function = function;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.roles = roles;
        this.breeding = breeding;
        this.dogs = dogs;
        this.sentMessages = sentMessages;
        this.receivedMessages = receivedMessages;
    }



}
