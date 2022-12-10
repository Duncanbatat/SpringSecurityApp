package ru.artdy.SpringSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artdy.SpringSecurityApp.models.Person;
import ru.artdy.SpringSecurityApp.repositories.PeopleRepository;

@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void register(Person person) {
        peopleRepository.save(person);
    }
}
