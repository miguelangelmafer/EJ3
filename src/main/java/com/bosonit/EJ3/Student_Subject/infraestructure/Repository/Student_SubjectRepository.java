package com.bosonit.EJ3.Student_Subject.infraestructure.Repository;

import com.bosonit.EJ3.Student_Subject.domain.Student_SubjectEnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Student_SubjectRepository extends JpaRepository<Student_SubjectEnt,String> {
}
