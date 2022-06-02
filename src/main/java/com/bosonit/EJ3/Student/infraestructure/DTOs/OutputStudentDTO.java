package com.bosonit.EJ3.Student.infraestructure.DTOs;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import lombok.Data;

@Data
public class OutputStudentDTO {

    private String id_student;
    private PersonaEnt personaEnt;
    private Integer num_hours_week;
    private String comments;
    //private String id_teacher;
    private String branch;
}
