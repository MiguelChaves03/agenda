package com.ejercicio.Agenda.model.domain;

import org.springframework.data.mongodb.core.mapping.*;
import lombok.*;
import org.springframework.data.annotation.*;
import java.time.*;

@Document(collection = "persons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private String codigo;

    private String firstName;

    private String lastName;

    private String street;

    private Integer postalCode;

    private String city;

    private LocalDate birthday;

}
