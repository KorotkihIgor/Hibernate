package ru.netology.Hibernate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.Hibernate.model.Person;
import ru.netology.Hibernate.service.UserSevice;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class UserController {
    private UserSevice userSevice;

    public UserController(UserSevice userSevice) {
        this.userSevice = userSevice;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> getStart() {
        return ResponseEntity.ok("Hello User!");
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return userSevice.getPersonsByCity(city);
    }

    @GetMapping("/name-surname")
    public Optional<Person> getFindByNameAndSurname(@RequestParam("name") String name,
                                                    @RequestParam("surname") String surname) {
        return userSevice.getFindByNameAndSurname(name, surname);
    }

    @GetMapping("/lessThan-age")
    public List<Person> getFindByPersonIdAgeLessThanOrderByPersonIdAge(@RequestParam("age") int age) {
        return userSevice.getFindByPersonIdAgeLessThanOrderByPersonIdAge(age);
    }
}
