package com.breedmanager.entitis;

import javax.persistence.*;

@Entity
@Table(name = "litter")
public class Litter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "breeder")
    private User breeder;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
//    @JoinColumn(name = "father")
//    private Dog father;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
//    @JoinColumn(name = "mother")
//    private Dog mother;
    private String dateOfBirth;
    private int amountOfPuppies;

    public Litter() {
    }

    public Litter(User breeder, String dateOfBirth, int amountOfPuppies) {
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






