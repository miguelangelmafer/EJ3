package com.bosonit.EJ3.Student_Subject.infraestructure.Controller;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.Repository.StudentRepository;
import com.bosonit.EJ3.Student_Subject.application.Port.CreateStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.Repository.Student_SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStudent_Subject implements CreateStudent_SubjectPort {

    @Autowired
    Student_SubjectRepository student_subjectRepository;

    public Student_SubjectEnt addSubject(Student_SubjectEnt student_subjectEnt) {
        return student_subjectRepository.save(student_subjectEnt);}

}
