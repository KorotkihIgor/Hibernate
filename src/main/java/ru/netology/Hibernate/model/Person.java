package ru.netology.Hibernate.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Persons")
public class Person {

    @EmbeddedId
    private PersonId personId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false, length = 1024)
    private String city;
}
