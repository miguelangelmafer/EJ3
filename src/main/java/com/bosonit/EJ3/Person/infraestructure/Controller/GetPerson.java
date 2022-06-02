package com.bosonit.EJ3.Person.infraestructure.Controller;


import com.bosonit.EJ3.Person.Exceptions.NotFoundException;
import com.bosonit.EJ3.Person.application.Port.GetPersonPort;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.DTOs.OutPersonaDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class GetPerson {

    @Autowired
    GetPersonPort getPersonPort;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/id/{id}")

    public OutPersonaDTO getPersonByID(@PathVariable Integer id) throws Exception {
        try {
            PersonaEnt personaEnt = getPersonPort.getPersonaByID(id);
            OutPersonaDTO outPersonaDTO = modelMapper.map(personaEnt,OutPersonaDTO.class);
            return outPersonaDTO;
        } catch (Exception e) {
            throw new NotFoundException("No se encuentra el ususario " + id);
        }
    }

    @GetMapping("/name/{nombre}")
    public List<OutPersonaDTO> getPersonByName(@PathVariable String nombre) throws Exception {
        List <PersonaEnt> personaEntList = getPersonPort.getPersonByName(nombre);
        TypeToken<List<OutPersonaDTO>> typeToken = new TypeToken<>() {
        };
        List<OutPersonaDTO> outPersonaDTOList = modelMapper.map(personaEntList, typeToken.getType());
        return outPersonaDTOList;
    }

    @GetMapping("/all")
    public List<OutPersonaDTO> getAllPerson(){
        List <PersonaEnt> personaEntList = getPersonPort.getAllPerson();
        TypeToken<List<OutPersonaDTO>> typeToken = new TypeToken<>() {
        };
        List<OutPersonaDTO> outPersonaDTOList = modelMapper.map(personaEntList, typeToken.getType());
        return outPersonaDTOList;
    }

}



