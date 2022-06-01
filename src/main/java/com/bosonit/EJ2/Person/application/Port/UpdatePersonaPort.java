package com.bosonit.EJ2.Person.application.Port;

import com.bosonit.EJ2.Person.domain.PersonaEnt;
import com.bosonit.EJ2.Person.infraestructure.DTOs.PersonaDTO;

public interface UpdatePersonaPort {

    public PersonaEnt updatePerson(PersonaEnt personaOld, PersonaDTO personaNew);
}
