package com.CarpeNoctem.studentInfoManager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "classroom")
public class Classroom implements Serializable {
    @Id
    @GeneratedValue
    long classID;
    String classTeachersName;

    @OneToMany(mappedBy = "classroom",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> studentList;

    public Classroom(long classID, String classTeachersName, List<Student> studentList) {
        this.classID = classID;
        this.classTeachersName = classTeachersName;
        this.studentList = studentList;
    }

    public Classroom() {

    }

    public long getClassID() {
        return classID;
    }

    public void setClassID(long classID) {
        this.classID = classID;
    }

    public String getClassTeachersName() {
        return classTeachersName;
    }

    public void setClassTeachersName(String classTeachersName) {
        this.classTeachersName = classTeachersName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}

