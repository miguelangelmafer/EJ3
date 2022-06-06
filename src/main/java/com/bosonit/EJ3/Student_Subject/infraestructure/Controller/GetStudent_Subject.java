package com.bosonit.EJ3.Student_Subject.infraestructure.Controller;

import com.bosonit.EJ3.Student_Subject.application.Port.GetStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.OutputStudent_SubjectDTO;
import com.bosonit.EJ3.Teacher.application.Port.GetTeacherPort;
import com.bosonit.EJ3.Teacher.infraestructure.DTOs.OutputTeacherDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class GetStudent_Subject {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    GetStudent_SubjectPort getStudent_subjectPort;

    @GetMapping("/id/{id}")
    public OutputStudent_SubjectDTO getSubjectByID(@PathVariable String id) throws Exception{
        return new OutputStudent_SubjectDTO(getStudent_subjectPort.getSubjectByID(id));
    }
}
