package com.CarpeNoctem.studentInfoManager.service;

import com.CarpeNoctem.studentInfoManager.exceptions.UserNotFoundException;
import com.CarpeNoctem.studentInfoManager.model.Classroom;
import com.CarpeNoctem.studentInfoManager.model.Student;
import com.CarpeNoctem.studentInfoManager.repo.ClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private final ClassRepo classRepo;

    @Autowired
    public ClassService(ClassRepo classRepo) {
        this.classRepo = classRepo;
    }

    public Optional<List<Student>> findStudentsByClassID(long classID){
        return classRepo.findStudentsByClassID(classID);
    }

    public Classroom findClassByClassID(long classID){
        return classRepo.findClassroomByClassID(classID).orElseThrow( ()->new UserNotFoundException("Class with ID "+ classID +" was not Found"));
    }

    public List<Classroom> findAllClassrooms(){
        return classRepo.findAll();
    }
}
