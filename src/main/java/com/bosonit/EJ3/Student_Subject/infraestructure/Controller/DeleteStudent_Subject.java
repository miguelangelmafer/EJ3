package com.bosonit.EJ3.Student_Subject.infraestructure.Controller;

import com.bosonit.EJ3.Student_Subject.application.Port.DeleteStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.application.Port.GetStudent_SubjectPort;
import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import com.bosonit.EJ3.Teacher.domain.TeacherEnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class DeleteStudent_Subject {
    @Autowired
    GetStudent_SubjectPort getStudent_subjectPort;
    @Autowired
    DeleteStudent_SubjectPort deleteStudent_subjectPort;

    @DeleteMapping("/delete/{id}")

    public String deleteSubject(@PathVariable String id) throws Exception {

        Student_SubjectEnt student_subjectEnt = getStudent_subjectPort.getSubjectByID(id);
        deleteStudent_subjectPort.deleteSubject(student_subjectEnt);
        return "Asignatura eliminada";

    }
}
