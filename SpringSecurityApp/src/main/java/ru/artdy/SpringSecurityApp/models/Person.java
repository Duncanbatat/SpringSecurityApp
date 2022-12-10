package ru.artdy.SpringSecurityApp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@SuppressWarnings("com.haulmont.jpb.LombokDataInspection")
@Data
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Username shouldn't be empty!")
    @Size(min = 2, max = 100, message = "Username must be between 2 and 100 characters long!")
    @Column(name = "username")
    private String username;

    @Min(value = 1900, message = "Year of birth must be greater than 1900!")
    @Column(name = "year_of_birth", nullable = false)
    private int yearOfBirth;


    @NotEmpty(message = "Password shouldn't be empty!")
    @Column(name = "password")
    private String password;
}
