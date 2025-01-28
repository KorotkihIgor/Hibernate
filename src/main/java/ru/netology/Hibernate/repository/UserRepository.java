package ru.netology.Hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.Hibernate.model.Person;

import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery("select p from Person p where p.city_of_living = :nameCity", Person.class)
                .setParameter("nameCity", city)
                .getResultList();
    }
}