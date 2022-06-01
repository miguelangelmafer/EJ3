package com.bosonit.EJ2.Student.domain;

import javax.persistence.Entity;

@Entity
public class StudentEnt {
    private String id_student;
    private String id_person;
    private Integer num_hours_week;
    private String comments;
    private String id_teacher;
    private String branch;
}
