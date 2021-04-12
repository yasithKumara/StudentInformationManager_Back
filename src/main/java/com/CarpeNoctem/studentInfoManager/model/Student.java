package com.CarpeNoctem.studentInfoManager.model;

/*
A web application store and retrieve student information.
The web application should be able to perform CRUD operations on student information and
class information.
Types of data
1. Student: Information about the student (eg: full name, address, parent names, date of
birth, enrollment date, etc)
2. Class: Information about the class (class-id, class teacher information, students in the
class)
Note: You need to manage a one-to-many relationship in the database with class and student
tables.
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    long studentID; //long ??
    String name;
    String address;
    String mothersName;
    String fathersName;
    String dateOfBirth; //date can also be used for type
    String enrollmentDate; //date can also be used for type

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classid", referencedColumnName = "classid",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Classroom classroom;

    public Student(){}

    public Student( String name, String address, String mothersName, String fathersName, String dateOfBirth, String enrollmentDate, Classroom classroom) {
        //this.studentID = studentID; //also removed it in parameters
        this.name = name;
        this.address = address;
        this.mothersName = mothersName;
        this.fathersName = fathersName;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;
        this.classroom = classroom;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString(){
        return "Student ID : "+ studentID +
                "Name : " + name +
                "Address : " + address +
                "Mother's Name : " + mothersName +
                "Father's Name : " + fathersName +
                "Date of Birth : " + dateOfBirth +
                "Enrollment Date : " + enrollmentDate;
    }
}
