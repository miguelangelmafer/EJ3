package com.bosonit.EJ3.Student_Subject.application.UseCase;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.Repository.StudentRepository;
import com.bosonit.EJ3.Student_Subject.application.Port.GetStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Student_Subject.infraestructure.Repository.Student_SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetStudent_SubjectUseCase implements GetStudent_SubjectPort {
    @Autowired
    Student_SubjectRepository student_subjectRepository;

    public Student_SubjectEnt getSubjectByID(String id) throws Exception{
        return student_subjectRepository.findById(id).orElseThrow(()-> new Exception("Asignatura no encontrada"));
    }
}
