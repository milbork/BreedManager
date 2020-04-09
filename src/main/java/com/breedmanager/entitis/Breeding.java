package com.breedmanager.entitis;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "breeding")
public class Breeding {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String dogsBreed;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "breeder_id")
    private User breeder;

    @OneToMany(mappedBy = "breeding", fetch = FetchType.LAZY)
    private List<Litter> litters;
    private String available;

    public Breeding() {
    }

    public Breeding(String name, String dogsBreed, User breeder, List<Litter> litters, String available) {
        this.name = name;
        this.dogsBreed = dogsBreed;
        this.breeder = breeder;
        this.litters = litters;
        this.available = available;
    }

    public Breeding(String name) {
        this.name = name;
    }

    public Breeding(String name, String dogsBreed, User breeder, String available) {
        this.name = name;
        this.dogsBreed = dogsBreed;
        this.breeder = breeder;
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
