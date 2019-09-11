package com.breedmanager.entitis;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "litter")
public class Litter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "breeder")
    private Breeder breeder;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "dog")
    private Dog dog;
    private LocalDate dateOfBirth;
    private Integer amountOfPuppies;

    public Litter() {
    }

    public Litter(Breeder breeder, Dog dog, LocalDate dateOfBirth, Integer amountOfPuppies) {
        this.breeder = breeder;
        this.dog = dog;
        this.dateOfBirth = dateOfBirth;
        this.amountOfPuppies = amountOfPuppies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Breeder getBreeder() {
        return breeder;
    }

    public void setBreeder(Breeder breeder) {
        this.breeder = breeder;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAmountOfPuppies() {
        return amountOfPuppies;
    }

    public void setAmountOfPuppies(Integer amountOfPuppies) {
        this.amountOfPuppies = amountOfPuppies;
    }
}
