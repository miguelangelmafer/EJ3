package com.bosonit.EJ3.Teacher.infraestructure.Controller;

import com.bosonit.EJ3.Teacher.application.Port.CreateTeacherPort;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.DTOs.InputTeacherDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class CreateTeacher {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CreateTeacherPort createTeacherPort;

    @PostMapping("/add")
    public InputTeacherDTO addTeacher(@RequestBody InputTeacherDTO inputTeacherDTO){
        TeacherEnt teacherEnt = createTeacherPort.addTeacher(modelMapper.map(inputTeacherDTO, TeacherEnt.class));
        inputTeacherDTO.setId_teacher(teacherEnt.getId_teacher());
        return inputTeacherDTO;
    }
}
