package ru.artdy.SpringSecurityApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PersonDTO {

    @NotEmpty(message = "Username shouldn't be empty!")
    @Size(min = 2, max = 100, message = "Username must be between 2 and 100 characters long!")
    @Getter @Setter
    private String username;

    @Min(value = 1900, message = "Year of birth must be greater than 1900!")
    @Getter @Setter
    private int yearOfBirth;

    @Getter @Setter
    private String password;
}
