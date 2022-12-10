package ru.artdy.SpringSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artdy.SpringSecurityApp.models.Person;
import ru.artdy.SpringSecurityApp.repositories.PeopleRepository;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Person getPersonByUsername(String username) {
        return peopleRepository.getPersonByUsername(username).orElse(null);
    }
}
