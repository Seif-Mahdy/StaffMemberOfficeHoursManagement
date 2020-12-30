package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "officehoursmangementsystem")
public class StudentEntity {
    private String studentId;
    private String studentName;
    private String studentNumber;
    private String studentEmail;
    private String studentPassword;

    @Id
    @Column(name = "StudentId")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "StudentName")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "StudentNumber")
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Basic
    @Column(name = "StudentEmail")
    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Basic
    @Column(name = "StudentPassword")
    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(studentName, that.studentName) && Objects.equals(studentNumber, that.studentNumber) && Objects.equals(studentEmail, that.studentEmail) && Objects.equals(studentPassword, that.studentPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, studentNumber, studentEmail, studentPassword);
    }
}
