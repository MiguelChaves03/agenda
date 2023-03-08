package com.ejercicio.Agenda.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.ejercicio.Agenda.model.domain.*;

@RequestMapping
public interface PersonApi {

    @GetMapping("/persons")
    ResponseEntity<?> getAllPersons();

    @GetMapping("/person/{id}")
    ResponseEntity<?> getPersonById(@PathVariable String id);

    @PostMapping("/person")
    ResponseEntity<?> createPerson(@RequestBody Person person);

    @PutMapping("/person/{id}")
    ResponseEntity<?> updatePerson(@RequestBody Person person, @PathVariable String id);

    @DeleteMapping("/person/{id}")
    ResponseEntity<?> deletePerson(@PathVariable String id);

    @DeleteMapping("/persons")
    ResponseEntity<?> deleteAllPersons();

}
