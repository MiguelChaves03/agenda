package com.ejercicio.Agenda.service.impl;

import org.springframework.stereotype.*;
import lombok.*;
import com.ejercicio.Agenda.service.*;
import org.springframework.beans.factory.annotation.*;
import com.ejercicio.Agenda.repository.*;
import com.ejercicio.Agenda.util.*;

import java.util.*;

import com.ejercicio.Agenda.model.*;
import com.ejercicio.Agenda.model.domain.*;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final PersonMapper personMapper;

    @Override
    public List<PersonDTO> getAllPersons() {

        List<Person> personList = (List<Person>) personRepository.findAll();

        Collections.sort(personList, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));

        Collections.sort(personList, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {

                return o1.getFirstName().compareTo(o2.getFirstName());

            }

        });

        return personMapper.fromListToDTO(personRepository.findAll());

    }

    @Override
    public PersonDTO getPersonById(String id) {

        return personMapper.fromEntityToDTO(personRepository.findById(id));

    }

    @Override
    public PersonDTO createPerson(Person person) {

        return personMapper.fromEntityToDTO(personRepository.save(person));

    }

    @Override
    public PersonDTO updatePerson(Person person, String id) {

        personRepository.deleteById(id);

        return personMapper.fromEntityToDTO(personRepository.save(person));

    }

    @Override
    public void deletePerson(String id) {

        if (personRepository.existsById(id)) {

            personRepository.deleteById(id);

        }

    }

    @Override
    public void deleteAllPersons() {

        List<Person> personList = personRepository.findAll();

        if (!personList.isEmpty()) {

            personRepository.deleteAll();

        }

    }

}
