package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coursetostaff", schema = "officehoursmangementsystem")
@IdClass(CoursetostaffEntityPK.class)
public class CoursetostaffEntity {
    private Integer courseId;
    private String staffId;

    @Id
    @Column(name = "CourseId")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Id
    @Column(name = "StaffId")
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursetostaffEntity that = (CoursetostaffEntity) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(staffId, that.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, staffId);
    }
}
