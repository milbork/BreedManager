package com.breedmanager.model.DTO;

import com.breedmanager.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DogDTO {
    private Long id;
    @NotBlank
    @Size(min = 2, max = 30)
    private String breed;
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;
    private User owner;
    @NotBlank
    @Size(min = 2, max = 30)
    private String dateOfBirth;


    public DogDTO() {
    }

    public DogDTO(@NotBlank @Size(min = 2, max = 30) String breed, @NotBlank @Size(min = 2, max = 30) String name,
                  User owner, @NotBlank @Size(min = 2, max = 30) String dateOfBirth) {
        this.breed = breed;
        this.name = name;
        this.owner = owner;
        this.dateOfBirth = dateOfBirth;
    }

    public DogDTO(Long id, @NotBlank @Size(min = 2, max = 30) String breed,
                  @NotBlank @Size(min = 2, max = 30) String name, User owner,
                  @NotBlank @Size(min = 2, max = 30) String dateOfBirth) {
        this.id = id;
        this.breed = breed;
        this.name = name;
        this.owner = owner;
        this.dateOfBirth = dateOfBirth;
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
