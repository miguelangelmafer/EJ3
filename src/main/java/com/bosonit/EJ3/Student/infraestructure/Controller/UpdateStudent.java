package com.bosonit.EJ3.Student.infraestructure.Controller;

import com.bosonit.EJ3.Person.Exceptions.UnprocesableException;
import com.bosonit.EJ3.Person.domain.PersonaEnt;
import com.bosonit.EJ3.Person.infraestructure.DTOs.InputPersonaDTO;
import com.bosonit.EJ3.Student.application.Port.GetStudentPort;
import com.bosonit.EJ3.Student.application.Port.UpdateStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.InputStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class UpdateStudent {

    @Autowired
    GetStudentPort getStudentPort;

    @Autowired
    UpdateStudentPort updateStudentPort;

    @PutMapping("/update/{id}")
    public StudentEnt updateStudent(@PathVariable String id, @RequestBody InputStudentDTO inputStudentDTO) throws Exception{
        StudentEnt studentEnt = getStudentPort.getStudentByID(id);
        updateStudentPort.updateStudent(studentEnt,inputStudentDTO);
        return studentEnt;
    }

}
