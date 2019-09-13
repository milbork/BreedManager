package com.breedmanager.DTO;

import com.breedmanager.entitis.User;

import java.time.LocalDate;

public class DogDTO {
    private Long id;
    private String breed;
    private String name;
    private User owner;
    private String dateOfBirth;


    public DogDTO() {
    }

    public DogDTO(String breed, String name, User owner, String dateOfBirth, Long id) {
        this.breed = breed;
        this.name = name;
        this.owner = owner;
        this.dateOfBirth = dateOfBirth;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
