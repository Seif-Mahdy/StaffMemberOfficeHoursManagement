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
    private byte isNotified;

    @Id
    @Column(name = "AppointmentId", nullable = false)
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Basic
    @Column(name = "OfficeHourId", nullable = true)
    public Integer getOfficeHourId() {
        return officeHourId;
    }

    public void setOfficeHourId(Integer officeHourId) {
        this.officeHourId = officeHourId;
    }

    @Basic
    @Column(name = "StudentId", nullable = true, length = 8)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "StaffId", nullable = true, length = 8)
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "IsNotified", nullable = false)
    public byte getIsNotified() {
        return isNotified;
    }

    public void setIsNotified(byte isNotified) {
        this.isNotified = isNotified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentEntity that = (AppointmentEntity) o;
        return appointmentId == that.appointmentId && isNotified == that.isNotified && Objects.equals(officeHourId, that.officeHourId) && Objects.equals(studentId, that.studentId) && Objects.equals(staffId, that.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, officeHourId, studentId, staffId, isNotified);
    }
}
