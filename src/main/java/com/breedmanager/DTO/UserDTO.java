package com.breedmanager.DTO;

import com.breedmanager.entitis.Role;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import java.util.Set;

public class UserDTO {
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String password;

    @Email
    @NotEmpty
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotEmpty
    private String breedingName;


    public UserDTO() {
    }

    public UserDTO(Long id, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String password, @Email @NotEmpty String email, @NotEmpty String breedingName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.breedingName = breedingName;
    }

    public UserDTO(Long id, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String password, @Email @NotEmpty String email, @NotEmpty String breedingName, Set<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.breedingName = breedingName;

    }

    public UserDTO(Long id, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String password, @Email @NotEmpty String email, @NotEmpty String breedingName, int enabled) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.breedingName = breedingName;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
