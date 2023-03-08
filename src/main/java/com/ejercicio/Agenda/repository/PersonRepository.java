package com.ejercicio.Agenda.repository;

import org.springframework.stereotype.*;
import org.springframework.data.mongodb.repository.*;
import com.ejercicio.Agenda.model.domain.*;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

}
