package com.bosonit.EJ3.Student_Subject.application.UseCase;

import com.bosonit.EJ3.Student_Subject.application.Port.UpdateStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.DTOs.InputStudent_SubjectDTO;
import com.bosonit.EJ3.Student_Subject.infraestructure.Repository.Student_SubjectRepository;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.DTOs.InputTeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UpdateStudent_SubjectUseCase implements UpdateStudent_SubjectPort {
    @Autowired
    Student_SubjectRepository student_subjectRepository;

    public Student_SubjectEnt updateSubject(Student_SubjectEnt subjectOld, InputStudent_SubjectDTO subjectNew) {

        subjectOld.setSubject(subjectNew.getSubject());
        subjectOld.setComments(subjectNew.getComments());
        subjectOld.setInitial_date(subjectOld.getInitial_date());
        subjectOld.setFinish_date(subjectOld.getFinish_date());
        return student_subjectRepository.save(subjectOld);

    }
}