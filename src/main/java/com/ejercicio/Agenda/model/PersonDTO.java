package com.ejercicio.Agenda.model;

import lombok.*;
import java.time.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private String codigo;

    private String firstName;

    private String lastName;

    private String street;

    private Integer postalCode;

    private String city;

    private LocalDate birthday;

}
