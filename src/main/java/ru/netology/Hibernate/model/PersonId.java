package ru.netology.Hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class PersonId implements Serializable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(length = 200)
    private int age;
}
