package com.bosonit.EJ3.Student_Subject.application.Port;

import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;

import java.util.List;

public interface GetStudent_SubjectPort {
    public Student_SubjectEnt getSubjectByID(String id) throws Exception;
    public List<Student_SubjectEnt> getAllSubject();

}
