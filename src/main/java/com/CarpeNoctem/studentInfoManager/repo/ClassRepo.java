package com.CarpeNoctem.studentInfoManager.repo;

import com.CarpeNoctem.studentInfoManager.model.Classroom;
import com.CarpeNoctem.studentInfoManager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClassRepo extends JpaRepository<Classroom,Long> {

    Optional<List<Student>> findStudentsByClassID(Long aLong);
    Optional <Classroom> findClassroomByClassID(Long classID);
}
