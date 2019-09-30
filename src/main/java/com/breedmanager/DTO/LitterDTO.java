package com.breedmanager.DTO;

import com.breedmanager.entitis.Breeding;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class LitterDTO {

    private Long id;
//    private Dog father;
//    private Dog mother;
    @NotBlank
    private String dogsBreed;
    @NotBlank
    @Size(min = 2, max = 30)
    private String dateOfBirth;
    @Positive
    private int amountOfPuppies;
    private Breeding breeding;


    public LitterDTO() {
    }

    public LitterDTO(Long id, @NotBlank String dogsBreed, @NotBlank @Size(min = 2, max = 30) String dateOfBirth, @Positive int amountOfPuppies, Breeding breeding) {
        this.id = id;
        this.dogsBreed = dogsBreed;
        this.dateOfBirth = dateOfBirth;
        this.amountOfPuppies = amountOfPuppies;
        this.breeding = breeding;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Breeding getBreeding() {
        return breeding;
    }

    public void setBreeding(Breeding breeding) {
        this.breeding = breeding;
    }
}
