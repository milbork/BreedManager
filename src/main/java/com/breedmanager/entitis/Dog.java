package com.breedmanager.entitis;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "dog")
@Data
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String breed;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "owner")
    private User owner;
    private String dateOfBirth;

    public Dog() {
    }

    public Dog(String breed, String name, User owner,
               String dateOfBirth) {
        this.breed = breed;
        this.name = name;
        this.owner = owner;
        this.dateOfBirth = dateOfBirth;
    }

}


