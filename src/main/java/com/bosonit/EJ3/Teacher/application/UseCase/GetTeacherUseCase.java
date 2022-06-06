package com.bosonit.EJ3.Teacher.application.UseCase;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Teacher.application.Port.GetTeacherPort;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import com.bosonit.EJ3.Teacher.infraestructure.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTeacherUseCase implements GetTeacherPort {
    @Autowired
    TeacherRepository teacherRepository;

    public TeacherEnt getTeacherByID(String id) throws Exception {
        return teacherRepository.findById(id).orElseThrow(()-> new Exception("Profesor no encontrado"));
    }

    public List<TeacherEnt> getAllTeacher() {
        List<TeacherEnt> teacherEntList = teacherRepository.findAll();
        return teacherEntList;
    }
}
