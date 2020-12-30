package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "appointment", schema = "officehoursmangementsystem", catalog = "")
public class AppointmentEntity {
    private int appointmentId;
    private Integer officeHourId;
    private String studentId;
    private String staffId;
    private OfficehourEntity officehourByOfficeHourId;
    private StudentEntity studentByStudentId;
    private StaffmemberEntity staffmemberByStaffId;

    @Id
    @Column(name = "AppointmentId")
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Basic
    @Column(name = "OfficeHourId")
    public Integer getOfficeHourId() {
        return officeHourId;
    }

    public void setOfficeHourId(Integer officeHourId) {
        this.officeHourId = officeHourId;
    }

    @Basic
    @Column(name = "StudentId")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
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
        AppointmentEntity that = (AppointmentEntity) o;
        return appointmentId == that.appointmentId && Objects.equals(officeHourId, that.officeHourId) && Objects.equals(studentId, that.studentId) && Objects.equals(staffId, that.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, officeHourId, studentId, staffId);
    }

    @ManyToOne
    @JoinColumn(name = "OfficeHourId", referencedColumnName = "ID")
    public OfficehourEntity getOfficehourByOfficeHourId() {
        return officehourByOfficeHourId;
    }

    public void setOfficehourByOfficeHourId(OfficehourEntity officehourByOfficeHourId) {
        this.officehourByOfficeHourId = officehourByOfficeHourId;
    }

    @ManyToOne
    @JoinColumn(name = "StudentId", referencedColumnName = "StudentId")
    public StudentEntity getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(StudentEntity studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "StaffId", referencedColumnName = "StaffId")
    public StaffmemberEntity getStaffmemberByStaffId() {
        return staffmemberByStaffId;
    }

    public void setStaffmemberByStaffId(StaffmemberEntity staffmemberByStaffId) {
        this.staffmemberByStaffId = staffmemberByStaffId;
    }
}
