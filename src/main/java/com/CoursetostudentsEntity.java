package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coursetostudents", schema = "officehoursmangementsystem", catalog = "")
@IdClass(CoursetostudentsEntityPK.class)
public class CoursetostudentsEntity {
    private int courseId;
    private String studentId;
    private CourseEntity courseByCourseId;
    private StudentEntity studentByStudentId;

    @Id
    @Column(name = "CourseId")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Id
    @Column(name = "StudentId")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursetostudentsEntity that = (CoursetostudentsEntity) o;
        return courseId == that.courseId && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId);
    }

    @ManyToOne
    @JoinColumn(name = "CourseId", referencedColumnName = "CourseId", nullable = false)
    public CourseEntity getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(CourseEntity courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    @ManyToOne
    @JoinColumn(name = "StudentId", referencedColumnName = "StudentId", nullable = false)
    public StudentEntity getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(StudentEntity studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }
}
