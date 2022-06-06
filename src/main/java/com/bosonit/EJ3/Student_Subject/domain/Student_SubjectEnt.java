package com.bosonit.EJ3.Student_Subject.domain;

import com.bosonit.EJ3.StringPrefixedSequenceIdGenerator;
import lombok.Data;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;

@Data
@Entity
@Table(name="Asignaturas")
public class Student_SubjectEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq")
    @GenericGenerator(

            name = "subject_seq",

            strategy = "com.bosonit.EJ3.StringPrefixedSequenceIdGenerator",

            parameters = {

                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),

                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SBJ"),

                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")

            })
    private String id_subject;
    private String subject;
    private String comments;
    private Date initial_date;
    private Date finish_date;
    //private String id_student;

}
