package ru.netology.Hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.Hibernate.model.Person;
import ru.netology.Hibernate.service.UserSevice;

import java.util.List;

@RestController
public class UserController {
    private UserSevice userSevice;

    public UserController(UserSevice userSevice) {
        this.userSevice = userSevice;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return userSevice.getPersonsByCity(city);
    }
}
