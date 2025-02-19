package ru.netology.Hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.Hibernate.model.Person;
import ru.netology.Hibernate.model.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Person, PersonId> {

    List<Person> findByCity(String city);

    List<Person> findByPersonIdAgeLessThanOrderByPersonIdAge(int age);

    Optional<Person> findByPersonIdNameAndPersonIdSurname(String name, String surname);

    List<Person> findByPhoneNumber(String phoneNumber);
}