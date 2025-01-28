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
    @Id
    @Column(nullable = false)
    private String name;

    @Id
    @Column(nullable = false)
    private String surname;

    @Id
    @Column(length = 200)
    private int age;

    @Column
    private String phone_number;

    @Column(nullable = false, length = 1024)
    private String city_of_living;
}
