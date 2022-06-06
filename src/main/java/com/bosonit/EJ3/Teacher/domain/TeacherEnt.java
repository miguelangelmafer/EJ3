package com.bosonit.EJ3.Teacher.domain;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import org.jetbrains.annotations.NotNull;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class TeacherEnt {
    private String id_teacher;

    @OneToOne
    @JoinColumn(name="id_persona")
    private PersonaEnt personaEnt;

    private String comments;
    @NotNull
    private String branch;
}
