package com.bosonit.EJ3.Student.infraestructure.Controller;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.Repository.PersonaRepository;
import com.bosonit.EJ3.Student.infraestructure.DTOs.InputStudentDTO;
import com.bosonit.EJ3.Student.application.Port.CreateStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.Repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping ("/student")
public class CreateStudent {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CreateStudentPort createStudentPort;
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @PostMapping("/add")
    public InputStudentDTO addStudent(@RequestBody InputStudentDTO inputStudentDTO){
        Optional<PersonaEnt> personaEnt=personaRepository.findById(inputStudentDTO.getId_persona());
        Optional<TeacherEnt> teacherEnt=teacherRepository.findById(inputStudentDTO.getId_teacher());
//falta devolver en caso de no encontrar el id
        StudentEnt studentEnt =(modelMapper.map(inputStudentDTO, StudentEnt.class));
        studentEnt.setPersonaEnt(personaEnt.get());
        studentEnt.setTeacherEnt(teacherEnt.get());
        studentEnt = createStudentPort.addStudent(studentEnt);
        inputStudentDTO.setId_student(studentEnt.getId_student());
        return inputStudentDTO;
    }
}
