package com.bosonit.EJ3.Student.infraestructure.Controller;

import com.bosonit.EJ3.Student.infraestructure.DTOs.InputStudentDTO;
import com.bosonit.EJ3.Student.application.Port.CreateStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/student")
public class CreateStudent {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CreateStudentPort createStudentPort;

    @PostMapping("/add")
    public InputStudentDTO addStudent(@RequestBody InputStudentDTO inputStudentDTO){
        StudentEnt studentEnt = createStudentPort.addStudent(modelMapper.map(inputStudentDTO, StudentEnt.class));
        inputStudentDTO.setId_student(studentEnt.getId_student());
        return inputStudentDTO;
    }
}
