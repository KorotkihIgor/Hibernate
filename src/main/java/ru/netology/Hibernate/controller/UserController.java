package ru.netology.Hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/phone-number")
    public List<Person> getPhoneNumber(@RequestParam("username") String username,
                                       @RequestParam("phoneNumber") String phoneNumber) {
        return userSevice.getPhoneNumber(phoneNumber);
    }

    @GetMapping("/by-city")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return userSevice.getPersonsByCity(city);
    }

    @GetMapping("/name-surname")
    @RolesAllowed("WRITE")
    public Optional<Person> getFindByNameAndSurname(@RequestParam("name") String name,
                                                    @RequestParam("surname") String surname) {
        return userSevice.getFindByNameAndSurname(name, surname);
    }

    @GetMapping("/lessThan-age")
    @Secured("ROLE_READ")
    public List<Person> getFindByPersonIdAgeLessThanOrderByPersonIdAge(@RequestParam("age") int age) {
        return userSevice.getFindByPersonIdAgeLessThanOrderByPersonIdAge(age);
    }
}
