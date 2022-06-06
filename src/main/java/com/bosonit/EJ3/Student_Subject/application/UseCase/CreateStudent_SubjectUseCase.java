package com.bosonit.EJ3.Student_Subject.application.UseCase;

import com.bosonit.EJ3.Student_Subject.application.Port.CreateStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.InputStudent_SubjectDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class CreateStudent_SubjectUseCase {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CreateStudent_SubjectPort createStudent_subjectPort;

    @PostMapping("/add")
    public InputStudent_SubjectDTO addSubject(@RequestBody InputStudent_SubjectDTO inputStudent_subjectDTO){
        Student_SubjectEnt student_subjectEnt = createStudent_subjectPort.addSubject(modelMapper.map(inputStudent_subjectDTO, Student_SubjectEnt.class));
        inputStudent_subjectDTO.setId_subject(student_subjectEnt.getId_subject());
        return inputStudent_subjectDTO;
    }
}
