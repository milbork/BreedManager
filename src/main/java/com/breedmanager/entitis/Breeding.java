package com.breedmanager.entitis;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "breeding")
@Data
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

    public Breeding(String name) {
        this.name = name;
    }

    public Breeding(String name, String dogsBreed, User breeder, String available) {
        this.name = name;
        this.dogsBreed = dogsBreed;
        this.breeder = breeder;
        this.available = available;
    }
    public Breeding(String name, String dogsBreed, User breeder, List<Litter> litters, String available) {
        this.name = name;
        this.dogsBreed = dogsBreed;
        this.breeder = breeder;
        this.litters = litters;
        this.available = available;
    }

}
