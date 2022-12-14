package ru.artdy.SpringSecurityApp.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class PersonErrorResponse {

    @Getter @Setter
    private String message;

    @Getter @Setter
    private long timestamp;
}
