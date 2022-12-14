package ru.artdy.SpringSecurityApp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;

    @NotEmpty(message = "Username shouldn't be empty!")
    @Size(min = 2, max = 100, message = "Username must be between 2 and 100 characters long!")
    @Getter @Setter
    private String username;

    @Min(value = 1900, message = "Year of birth must be greater than 1900!")
    @Getter @Setter
    private int yearOfBirth;

    @NotEmpty
    @Getter @Setter
    private String role;

    @Getter @Setter
    private String password;
}
