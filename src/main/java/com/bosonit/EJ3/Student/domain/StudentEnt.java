package com.bosonit.EJ3.Student.domain;

import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table (name="Estudiantes")
public class StudentEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @GenericGenerator(

            name = "student_seq",

            strategy = "com.bosonit.EJ3.StringPrefixedSequenceIdGenerator",

            parameters = {

                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),

                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "STD"),

                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")

            })
    private String id_student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_persona")
    private PersonaEnt personaEnt;

    private Integer num_hours_week;

    private String comments;

    //private String id_teacher;

    @NotNull
    private String branch;

}
