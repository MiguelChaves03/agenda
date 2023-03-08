package com.ejercicio.Agenda.service;

import java.util.*;
import com.ejercicio.Agenda.model.*;
import com.ejercicio.Agenda.model.domain.*;

public interface PersonService {

    List<PersonDTO> getAllPersons();

    PersonDTO getPersonById(String id);

    PersonDTO createPerson(Person person);

    PersonDTO updatePerson(Person person, String id);

    void deletePerson(String id);

    void deleteAllPersons();

}
