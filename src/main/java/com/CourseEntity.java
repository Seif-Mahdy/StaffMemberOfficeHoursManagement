package com;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "officehoursmangementsystem", catalog = "")
public class CourseEntity {
    private int courseId;
    private String courseName;
    private Collection<CoursetostaffEntity> coursetostaffsByCourseId;
    private Collection<CoursetostudentsEntity> coursetostudentsByCourseId;

    @Id
    @Column(name = "CourseId")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "CourseName")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return courseId == that.courseId && Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName);
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<CoursetostaffEntity> getCoursetostaffsByCourseId() {
        return coursetostaffsByCourseId;
    }

    public void setCoursetostaffsByCourseId(Collection<CoursetostaffEntity> coursetostaffsByCourseId) {
        this.coursetostaffsByCourseId = coursetostaffsByCourseId;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<CoursetostudentsEntity> getCoursetostudentsByCourseId() {
        return coursetostudentsByCourseId;
    }

    public void setCoursetostudentsByCourseId(Collection<CoursetostudentsEntity> coursetostudentsByCourseId) {
        this.coursetostudentsByCourseId = coursetostudentsByCourseId;
    }
}
