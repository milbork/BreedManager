package com.breedmanager.DTO;
import org.hibernate.validator.constraints.Email;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {
    private Long id;
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;
    @NotBlank
    @Size(min = 2, max = 30)
    private String password;
    @NotBlank
    @Email
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @NotNull
    private String function;
    private String breedingName;

    public UserDTO() {
    }

    public UserDTO(Long id, @NotBlank @Size(min = 2, max = 30) String firstName,
                   @NotBlank @Size(min = 2, max = 30) String lastName,
                   @NotBlank @Size(min = 2, max = 30) String password,
                   @NotBlank @Email String email,
                   @NotBlank String function, String breedingName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.function = function;
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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
