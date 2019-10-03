package com.breedmanager.DTO;

import com.breedmanager.entitis.Litter;
import com.breedmanager.entitis.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class BreedingDTO {


    private Long id;
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;
    @NotBlank
    @Size(min = 2, max = 30)
    private String dogsBreed;

    private User breeder;

    private List<Litter> litters;

    private String available;

    public BreedingDTO() {
    }

    public BreedingDTO(Long id, @NotBlank @Size(min = 2, max = 30) String name, @NotBlank @Size(min = 2, max = 30) String dogsBreed, User breeder, List<Litter> litters, String available) {
        this.id = id;
        this.name = name;
        this.dogsBreed = dogsBreed;
        this.breeder = breeder;
        this.litters = litters;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDogsBreed() {
        return dogsBreed;
    }

    public void setDogsBreed(String dogsBreed) {
        this.dogsBreed = dogsBreed;
    }

    public User getBreeder() {
        return breeder;
    }

    public void setBreeder(User breeder) {
        this.breeder = breeder;
    }

    public List<Litter> getLitters() {
        return litters;
    }

    public void setLitters(List<Litter> litters) {
        this.litters = litters;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
