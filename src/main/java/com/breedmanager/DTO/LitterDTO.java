package com.breedmanager.DTO;

import com.breedmanager.entitis.User;

public class LitterDTO {

    private Long id;
    private User breeder;

//    private Dog father;
//    private Dog mother;

    private String dateOfBirth;
    private int amountOfPuppies;

    public LitterDTO() {
    }

    public LitterDTO(Long id, User breeder, String dateOfBirth, int amountOfPuppies) {
        this.id = id;
        this.breeder = breeder;
        this.dateOfBirth = dateOfBirth;
        this.amountOfPuppies = amountOfPuppies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getBreeder() {
        return breeder;
    }

    public void setBreeder(User breeder) {
        this.breeder = breeder;
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
