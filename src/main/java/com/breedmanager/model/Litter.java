package com.breedmanager.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "litter")
@Data
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
    private boolean available;


    public Litter() {
    }

    public Litter(Breeding breeding) {
        this.breeding = breeding;
    }

    public Litter(Breeding breeding, String dogsBreed, String dateOfBirth, int amountOfPuppies, boolean available) {
        this.breeding = breeding;
        this.dogsBreed = dogsBreed;
        this.dateOfBirth = dateOfBirth;
        this.amountOfPuppies = amountOfPuppies;
        this.available = available;
    }

}







