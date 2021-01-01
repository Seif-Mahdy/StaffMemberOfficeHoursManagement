package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "officehoursmangementsystem")
public class CourseEntity {
    private Integer courseId;
    private String courseName;

    @Id
    @Column(name = "CourseId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
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
        return Objects.equals(courseId, that.courseId) && Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName);
    }
}
