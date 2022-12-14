package ru.artdy.SpringSecurityApp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.artdy.SpringSecurityApp.security.PersonDetails;

import java.util.Map;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public Map<String, String> sayHello() {
        return Map.of("message", "Hello!");
    }

    @GetMapping("/show_person_details")
    @ResponseBody
    public String showPersonDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        return personDetails.getUsername();
    }
}
