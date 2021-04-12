package com.CarpeNoctem.studentInfoManager;

import com.CarpeNoctem.studentInfoManager.exceptions.UserNotFoundException;
import com.CarpeNoctem.studentInfoManager.model.Classroom;
import com.CarpeNoctem.studentInfoManager.model.Student;
import com.CarpeNoctem.studentInfoManager.repo.ClassRepo;
import com.CarpeNoctem.studentInfoManager.repo.StudentRepo;
import com.CarpeNoctem.studentInfoManager.service.ClassService;
import com.CarpeNoctem.studentInfoManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/student")
public class StudentResource {
    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    ClassRepo classRepo;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = studentService.findAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/find/{studentID}")
    public ResponseEntity<Student> getStudentByStudentID(@PathVariable("studentID") long studentID){
        Student student = studentService.findStudentByStudentID(studentID);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //when adding the classroom had to edit it severely
    //https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/
//    @PostMapping("/add")
//    public ResponseEntity<Student> addStudent(@RequestBody Student student){
//        Student newStudent = studentService.addStudent(student);
//        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
//    }

    @PostMapping("/{classID}/add")
    public ResponseEntity<Student> addStudent(@PathVariable ("classID") long classID,@RequestBody Student student){
        classRepo.findClassroomByClassID(classID).map(classroom->{
            student.setClassroom(classroom);
            return studentRepo.save(student);
        }).orElseThrow((() -> new UserNotFoundException("classID " + classID + " not found")));
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

//    @PutMapping("/update")
//    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
//        Student updateStudent = studentService.updateStudent(student);
//        return new ResponseEntity<>(updateStudent, HttpStatus.CREATED);
//    }

    @PutMapping("/{classID}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable ("classID") long classID,@RequestBody Student student){
        classRepo.findClassroomByClassID(classID).map(classroom->{
            student.setClassroom(classroom);
            return studentRepo.save(student);
        }).orElseThrow((() -> new UserNotFoundException("classID " + classID + " not found")));
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{studentID}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("studentID") long studentID){
        studentService.deleteStudent(studentID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
