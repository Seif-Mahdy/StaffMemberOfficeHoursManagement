package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coursetostaff", schema = "officehoursmangementsystem", catalog = "")
@IdClass(CoursetostaffEntityPK.class)
public class CoursetostaffEntity {
    private int courseId;
    private String staffId;
    private CourseEntity courseByCourseId;
    private StaffmemberEntity staffmemberByStaffId;

    @Id
    @Column(name = "CourseId")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
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
        return courseId == that.courseId && Objects.equals(staffId, that.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, staffId);
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
    @JoinColumn(name = "StaffId", referencedColumnName = "StaffId", nullable = false)
    public StaffmemberEntity getStaffmemberByStaffId() {
        return staffmemberByStaffId;
    }

    public void setStaffmemberByStaffId(StaffmemberEntity staffmemberByStaffId) {
        this.staffmemberByStaffId = staffmemberByStaffId;
    }
}
