package com.bosonit.EJ3.Student_Subject.application.Port;

import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;

public interface GetStudent_SubjectPort {
    public Student_SubjectEnt getSubjectByID(String id) throws Exception;
}
