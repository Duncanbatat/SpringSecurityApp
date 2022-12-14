package ru.artdy.SpringSecurityApp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.artdy.SpringSecurityApp.dto.PersonDTO;
import ru.artdy.SpringSecurityApp.models.Person;
import ru.artdy.SpringSecurityApp.services.RegistrationService;
import ru.artdy.SpringSecurityApp.util.JWTUtil;
import ru.artdy.SpringSecurityApp.util.PersonErrorResponse;
import ru.artdy.SpringSecurityApp.util.PersonNotCreatedException;
import ru.artdy.SpringSecurityApp.util.PersonValidator;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final RegistrationService registrationService;
    private final PersonValidator personValidator;
    private final JWTUtil jwtUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthController(RegistrationService registrationService, PersonValidator personValidator, JWTUtil jwtUtil, ModelMapper modelMapper) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;
        this.jwtUtil = jwtUtil;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registration")
    public Map<String, String> performRegistration(@RequestBody @Valid PersonDTO personDTO, BindingResult bindingResult) {
        System.out.println("Ebanoe govno");
        Person person = convertToPerson(personDTO);
        performValidation(person, bindingResult);
        registrationService.register(person);
        String token = jwtUtil.generateToken(person.getUsername());
        return Map.of("jwt-token", token);
    }

    private Person convertToPerson(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }

    private void performValidation(Person person, BindingResult bindingResult) throws PersonNotCreatedException {
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            StringBuilder message = new StringBuilder();
            bindingResult.getFieldErrors().forEach(e -> message
                    .append(e.getField())
                    .append(" — ")
                    .append(e.getDefaultMessage())
                    .append("; "));
            throw new PersonNotCreatedException(message.toString());
        }
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotCreatedException e) {
        PersonErrorResponse response = new PersonErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
