package ru.netology.Hibernate.service;

import org.springframework.stereotype.Service;
import ru.netology.Hibernate.model.Person;
import ru.netology.Hibernate.repository.UserRepository;

import java.util.List;

@Service
public class UserSevice {
    private UserRepository userRepository;

    public UserSevice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return userRepository.getPersonsByCity(city);
    }
}
