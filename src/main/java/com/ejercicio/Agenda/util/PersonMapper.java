package com.ejercicio.Agenda.util;

import org.springframework.stereotype.*;
import lombok.*;
import org.modelmapper.*;
import com.ejercicio.Agenda.model.*;
import com.ejercicio.Agenda.model.domain.*;
import java.util.*;

@Component
@RequiredArgsConstructor
public class PersonMapper {

    private final ModelMapper modelMapper;

    public PersonDTO fromEntityToDTO(Person person) {

        return modelMapper.map(person, PersonDTO.class);

    }

    public PersonDTO fromEntityToDTO(Optional<Person> personOptional) {

        return modelMapper.map(personOptional, PersonDTO.class);

    }

    public List<PersonDTO> fromListToDTO(List<Person> personList) {

        List<PersonDTO> personDTOList = new ArrayList<>();

        for (Person person : personList) {

            personDTOList.add(modelMapper.map(person, PersonDTO.class));

        }

        return personDTOList;

    }

    public Person fromDTOToEntity(PersonDTO personDTO) {

        return modelMapper.map(personDTO, Person.class);

    }

}
