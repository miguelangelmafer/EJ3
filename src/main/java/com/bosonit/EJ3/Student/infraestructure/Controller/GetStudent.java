package com.bosonit.EJ3.Student.infraestructure.Controller;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.DTOs.OutPersonaDTO;
import com.bosonit.EJ3.Student.application.Port.GetStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.OutputStudentDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class GetStudent {

    @Autowired
    GetStudentPort getStudentPort;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/id/{id}")

    public OutputStudentDTO getStudentByID(String id) throws Exception{
        StudentEnt studentEnt = getStudentPort.getStudentByID(id);
        OutputStudentDTO outputStudentDTO = modelMapper.map(studentEnt,OutputStudentDTO.class);
        return outputStudentDTO;
    }

    @GetMapping("/all")
    public List<OutputStudentDTO> getAllStudent(){
        List <StudentEnt> studentEntList = getStudentPort.getAllStudent();
        TypeToken<List<OutputStudentDTO>> typeToken = new TypeToken<>() {
        };
        List<OutputStudentDTO> outputStudentDTOList = modelMapper.map(studentEntList, typeToken.getType());
        return outputStudentDTOList;
    }
}
