package com.bosonit.EJ3.Person.infraestructure.DTOs;

import com.bosonit.EJ3.Student.infraestructure.DTOs.OutputStudentDTO;
import lombok.Data;

@Data
public class OutputPersonaTeacherDTO extends OutPersonaDTO{

    private OutputPersonaTeacherDTO teacher;
}
