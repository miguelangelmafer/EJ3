package com.bosonit.EJ3.Student.application.Port;

import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.InputStudentDTO;

public interface UpdateStudentPort {
    public StudentEnt updateStudent(StudentEnt studentOld, InputStudentDTO studentNew);
}
