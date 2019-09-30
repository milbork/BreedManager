package com.breedmanager.entitis;

import javax.persistence.*;

@Entity
@Table(name = "litter")
public class Litter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "breeding")
    private Breeding breeding;
    private String dogsBreed;
    private String dateOfBirth;
    private int amountOfPuppies;


    public Litter() {
    }

    public Litter(Breeding breeding, String dogsBreed, String dateOfBirth, int amountOfPuppies) {
        this.breeding = breeding;
        this.dogsBreed = dogsBreed;
        this.dateOfBirth = dateOfBirth;
        this.amountOfPuppies = amountOfPuppies;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Breeding getBreeding() {
        return breeding;
    }

    public void setBreeding(Breeding breeding) {
        this.breeding = breeding;
    }

    public String getDogsBreed() {
        return dogsBreed;
    }

    public void setDogsBreed(String dogsBreed) {
        this.dogsBreed = dogsBreed;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAmountOfPuppies() {
        return amountOfPuppies;
    }

    public void setAmountOfPuppies(int amountOfPuppies) {
        this.amountOfPuppies = amountOfPuppies;
    }
}







