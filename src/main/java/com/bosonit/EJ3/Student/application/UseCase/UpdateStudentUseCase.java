package com.bosonit.EJ3.Student.application.UseCase;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.DTOs.InputPersonaDTO;
import com.bosonit.EJ3.Person.infraestructure.Repository.PersonaRepository;
import com.bosonit.EJ3.Student.application.Port.UpdateStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.InputStudentDTO;
import com.bosonit.EJ3.Student.infraestructure.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentUseCase implements UpdateStudentPort {

    @Autowired
    StudentRepository studentRepository;

    public StudentEnt updateStudent(StudentEnt studentOld, InputStudentDTO studentNew) {

        studentOld.setBranch(studentNew.getBranch());
        studentOld.setComments(studentNew.getComments());
        studentOld.setNum_hours_week(studentNew.getNum_hours_week());

        return studentRepository.save(studentOld);
    }
}