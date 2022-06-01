package com.bosonit.EJ2.Student_Subject.domain;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class StudentSubjectEnt {
    private String id_subject;
    private String id_student;
    private String subject;
    private String comments;
    private Date initial_date;
    private Date finish_date;
}
