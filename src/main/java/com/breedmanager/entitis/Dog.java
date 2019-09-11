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
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "breeder")
    private Breeder breeder;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user")
    private User user;
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "dog", fetch = FetchType.LAZY)
    private List<Litter> litters;

    public Dog() {
    }

    public Dog(String breed, String name, Breeder breeder, User user, LocalDate dateOfBirth, List<Litter> litters) {
        this.breed = breed;
        this.name = name;
        this.breeder = breeder;
        this.user = user;
        this.dateOfBirth = dateOfBirth;
        this.litters = litters;
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

    public Breeder getBreeder() {
        return breeder;
    }

    public void setBreeder(Breeder breeder) {
        this.breeder = breeder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Litter> getLitters() {
        return litters;
    }

    public void setLitters(List<Litter> litters) {
        this.litters = litters;
    }
}
