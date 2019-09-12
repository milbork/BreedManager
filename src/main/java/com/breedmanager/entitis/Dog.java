package com.breedmanager.entitis;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "dog")
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
//    @OneToMany(mappedBy = "dog", fetch = FetchType.LAZY)
//    private List<Litter> litters;

    public Dog() {
    }

    public Dog(String breed, String name, User owner,
               String dateOfBirth, List<Litter> litters) {
        this.breed = breed;
        this.name = name;
        this.owner = owner;
        this.dateOfBirth = dateOfBirth;
//        this.litters = litters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public List<Litter> getLitters() {
//        return litters;
//    }
//
//    public void setLitters(List<Litter> litters) {
//        this.litters = litters;
//    }
}


