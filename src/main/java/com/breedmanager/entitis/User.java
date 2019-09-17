package com.breedmanager.entitis;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private int enabled;
    private String email;
    private String breedingName;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Dog> dogs;

    @OneToMany(mappedBy = "breeder", fetch = FetchType.EAGER)
    private Set<Litter> litters;

    public User() {
    }

    public User(String firstName, String lastName, String password, int enabled, String email, String breedingName, Set<Role> roles, List<Dog> dogs, Set<Litter> litters) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.breedingName = breedingName;
        this.roles = roles;
        this.dogs = dogs;
        this.litters = litters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBreedingName() {
        return breedingName;
    }

    public void setBreedingName(String breedingName) {
        this.breedingName = breedingName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public Set<Litter> getLitters() {
        return litters;
    }

    public void setLitters(Set<Litter> litters) {
        this.litters = litters;
    }
}
