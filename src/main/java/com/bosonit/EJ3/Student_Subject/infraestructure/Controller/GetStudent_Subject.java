package com.bosonit.EJ3.Student_Subject.infraestructure.Controller;

import com.bosonit.EJ3.Student_Subject.application.Port.GetStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.OutputStudent_SubjectDTO;
import com.bosonit.EJ3.Teacher.application.Port.GetTeacherPort;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.DTOs.OutputTeacherDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/all")
    public List<OutputStudent_SubjectDTO> getAllSubject(){
        List <Student_SubjectEnt> student_subjectEntList = getStudent_subjectPort.getAllSubject();
        TypeToken<List<OutputStudent_SubjectDTO>> typeToken = new TypeToken<>() {
        };
        List<OutputStudent_SubjectDTO> outputStudent_subjectDTOList = modelMapper.map(student_subjectEntList, typeToken.getType());
        return outputStudent_subjectDTOList;
    }
}
