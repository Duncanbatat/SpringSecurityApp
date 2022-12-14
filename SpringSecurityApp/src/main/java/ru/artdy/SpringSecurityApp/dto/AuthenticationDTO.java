package ru.artdy.SpringSecurityApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AuthenticationDTO {

    @NotEmpty(message = "Username shouldn't be empty!")
    @Size(min = 2, max = 100, message = "Username must be between 2 and 100 characters long!")
    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;
}
