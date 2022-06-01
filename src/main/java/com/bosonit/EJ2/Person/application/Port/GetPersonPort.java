package com.bosonit.EJ2.Person.application.Port;

import com.bosonit.EJ2.Person.domain.PersonaEnt;

import java.util.List;

public interface GetPersonPort {

    public PersonaEnt getPersonaByID(Integer id) throws Exception;

    public List<PersonaEnt> getPersonByName(String name);

    public List<PersonaEnt> getAllPerson();

}
