package com.CarpeNoctem.studentInfoManager.repo;

import com.CarpeNoctem.studentInfoManager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    void deleteStudentByStudentID(Long studentID);

      Optional <Student> findStudentByStudentID(Long studentID);
}
