package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coursetostudents", schema = "officehoursmangementsystem")
@IdClass(CoursetostudentsEntityPK.class)
public class CoursetostudentsEntity {
    private Integer courseId;
    private String studentId;

    @Id
    @Column(name = "CourseId")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
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
        return Objects.equals(courseId, that.courseId) && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId);
    }
}
