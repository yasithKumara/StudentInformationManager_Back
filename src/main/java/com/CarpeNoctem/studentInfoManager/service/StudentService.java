package com.CarpeNoctem.studentInfoManager.service;

import com.CarpeNoctem.studentInfoManager.exceptions.UserNotFoundException;
import com.CarpeNoctem.studentInfoManager.model.Classroom;
import com.CarpeNoctem.studentInfoManager.model.Student;
import com.CarpeNoctem.studentInfoManager.repo.ClassRepo;
import com.CarpeNoctem.studentInfoManager.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;
    private final ClassRepo classRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo, ClassRepo classRepo) {
        this.studentRepo = studentRepo;
        this.classRepo = classRepo;
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    @Transactional
    public void deleteStudent(Long studentID){
        studentRepo.deleteStudentByStudentID(studentID);
    }

    public Student findStudentByStudentID(long studentID){
        return studentRepo.findStudentByStudentID(studentID).orElseThrow( ()->new UserNotFoundException("Student with ID "+ studentID +" was not Found"));
    }
}
