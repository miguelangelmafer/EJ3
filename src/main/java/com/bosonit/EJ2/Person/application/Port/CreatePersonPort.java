package com.bosonit.EJ2.Person.application.Port;


import com.bosonit.EJ2.Person.domain.PersonaEnt;

public interface CreatePersonPort {
    public PersonaEnt addPersona(PersonaEnt personaEnt) throws Exception;
}
