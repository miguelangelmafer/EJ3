package com.bosonit.EJ2.Person.infraestructure.Controller;

import com.bosonit.EJ2.Person.Exceptions.UnprocesableException;
import com.bosonit.EJ2.Person.application.UseCase.GetPersonUseCase;
import com.bosonit.EJ2.Person.application.Port.CreatePersonPort;
import com.bosonit.EJ2.Person.domain.PersonaEnt;
import com.bosonit.EJ2.Person.infraestructure.DTOs.PersonaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/person")
public class CreatePerson {

    @Autowired
    GetPersonUseCase getPersonUseCase;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    CreatePersonPort createPersonPort;

    @PostMapping("/add")
    public PersonaDTO addPersona(@RequestBody PersonaDTO personaDTO) throws Exception {
        try {
            PersonaEnt personaEnt = createPersonPort.addPersona(modelMapper.map(personaDTO, PersonaEnt.class));
            personaDTO.setId_persona(personaEnt.getId_persona());
            return personaDTO;
        } catch (Exception e) {
            throw new UnprocesableException("Valores incorrectos");
        }
    }
}
