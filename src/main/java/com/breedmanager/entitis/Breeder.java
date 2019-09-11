package com.breedmanager.entitis;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "breeder")
public class Breeder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String breedingName;

    @OneToMany(mappedBy = "breeder", fetch = FetchType.LAZY)
    private List<Dog> dogs;

    @OneToMany(mappedBy = "breeder", fetch = FetchType.LAZY)
    private List<Litter> litters;
    public Breeder() {
    }

    public Breeder(String firstName, String lastName, String password, String email, String breedingName, List<Dog> dogs, List<Litter> litters) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.breedingName = breedingName;
        this.dogs = dogs;
        this.litters = litters;
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


    public String getBreedingName() {
        return breedingName;
    }

    public void setBreedingName(String breedingName) {
        this.breedingName = breedingName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public List<Litter> getLitters() {
        return litters;
    }

    public void setLitters(List<Litter> litters) {
        this.litters = litters;
    }
}
