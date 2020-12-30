package com;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CoursetostaffEntityPK implements Serializable {
    private int courseId;
    private String staffId;

    @Column(name = "CourseId")
    @Id
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Column(name = "StaffId")
    @Id
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
        CoursetostaffEntityPK that = (CoursetostaffEntityPK) o;
        return courseId == that.courseId && Objects.equals(staffId, that.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, staffId);
    }
}
