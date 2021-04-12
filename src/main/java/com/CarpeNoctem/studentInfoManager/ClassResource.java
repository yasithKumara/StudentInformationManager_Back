package com.CarpeNoctem.studentInfoManager;

import com.CarpeNoctem.studentInfoManager.model.Classroom;
import com.CarpeNoctem.studentInfoManager.model.Student;
import com.CarpeNoctem.studentInfoManager.service.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/class")
public class ClassResource {

    private final ClassService classService;

    public ClassResource(ClassService classService) {
        this.classService = classService;
    }


//    @GetMapping("/find/{classid}")
//    public ResponseEntity<List<Student>> getStudentsByClassID(@PathVariable("classid") long classID){
//        Optional<List<Student>> students = classService.findStudentsByClassID(classID);
//        return new ResponseEntity(students, HttpStatus.OK);
//    }

    @GetMapping("/find/{classid}")
    public ResponseEntity<Classroom> getClassByClassID(@PathVariable("classid") long classID){
        Optional<Classroom> classroom = Optional.ofNullable(classService.findClassByClassID(classID));
        return new ResponseEntity(classroom, HttpStatus.OK);
    }

    @GetMapping("/findstudents/{classid}")
    public ResponseEntity<Classroom> getStudentsByClassID(@PathVariable("classid") long classID){
        Optional<Classroom> classroom = Optional.ofNullable(classService.findClassByClassID(classID));
        List<Student> studentList = classroom.get().getStudentList();
        return new ResponseEntity(studentList, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Classroom>> getAllStudents(){
        List<Classroom> studentList = classService.findAllClassrooms();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}
