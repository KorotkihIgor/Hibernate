package ru.netology.Hibernate.service;

import org.springframework.stereotype.Service;
import ru.netology.Hibernate.model.Person;
import ru.netology.Hibernate.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserSevice {
    private UserRepository userRepository;

    public UserSevice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return userRepository.findByCity(city);
    }

    public Optional<Person> getFindByNameAndSurname(String name, String surname) {
        return userRepository.findByPersonIdNameAndPersonIdSurname(name, surname);
    }

    public List<Person> getFindByPersonIdAgeLessThanOrderByPersonIdAge(int age) {
        return userRepository.findByPersonIdAgeLessThanOrderByPersonIdAge(age);
    }

}
