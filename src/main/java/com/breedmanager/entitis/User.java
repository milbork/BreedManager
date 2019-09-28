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
    private String function;
    private String firstName;
    private String lastName;
    private String password;
    private int enabled;
    private String email;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne(mappedBy = "breeder",
cascade = CascadeType.ALL,
fetch = FetchType.LAZY)
    private Breeding breeding;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Dog> dogs;


    public User() {
    }

    public User(String function, String firstName, String lastName, String password, int enabled, String email, Set<Role> roles, Breeding breeding, List<Dog> dogs) {
        this.function = function;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.roles = roles;
        this.breeding = breeding;
        this.dogs = dogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Breeding getBreeding() {
        return breeding;
    }

    public void setBreeding(Breeding breeding) {
        this.breeding = breeding;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

}
