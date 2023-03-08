package com.ejercicio.Agenda.controller;

import com.ejercicio.Agenda.model.PersonDTO;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import com.ejercicio.Agenda.service.*;
import org.springframework.http.*;
import com.ejercicio.Agenda.model.domain.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@CrossOrigin
@RestController
public class PersonController implements PersonApi {

    @Autowired
    private PersonService personService;

    @Override
    public ResponseEntity<?> getAllPersons() {

        List<PersonDTO> personList = (List<PersonDTO>) personService.getAllPersons();

        Collections.sort(personList, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));

        Collections.sort(personList, new Comparator<PersonDTO>() {

            @Override
            public int compare(PersonDTO o1, PersonDTO o2) {

                return o1.getFirstName().compareTo(o2.getFirstName());

            }

        });

        return ResponseEntity.ok(personList);

    }

    @Override
    public ResponseEntity<?> getPersonById(@PathVariable String id) {

        return ResponseEntity.ok(personService.getPersonById(id));

    }

    @Override
    public ResponseEntity<?> createPerson(@RequestBody Person person) {

        if (person == null) {

            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(personService.createPerson(person));

        } else {

            return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(person));

        }


    }

    @Override
    public ResponseEntity<?> updatePerson(Person person, String id) {

        if (person == null) {

            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(personService.updatePerson(person, id));

        } else {

            return ResponseEntity.ok(personService.updatePerson(person, id));

        }

    }

    @Override
    public ResponseEntity<?> deletePerson(@PathVariable String id) {

        if (personService.getPersonById(id) == null) {

            return ResponseEntity.notFound().build();

        } else {

            personService.deletePerson(id);

            return ResponseEntity.noContent().build();

        }

    }

    @Override
    public ResponseEntity<?> deleteAllPersons() {

        if (personService.getAllPersons() == null) {

            return ResponseEntity.notFound().build();

        } else {

            personService.deleteAllPersons();

            return ResponseEntity.noContent().build();

        }

    }

}
