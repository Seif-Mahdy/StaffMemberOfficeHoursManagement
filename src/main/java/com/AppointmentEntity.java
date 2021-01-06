package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "appointment", schema = "officehoursmangementsystem")
public class AppointmentEntity {
    private Integer appointmentId;
    private Integer officeHourId;
    private String studentId;
    private String staffId;

    @Id
    @Column(name = "AppointmentId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    public Integer getAppointmentId() {
        return appointmentId;
    }


    private void setAppointmentId(Integer appointmentId) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentEntity that = (AppointmentEntity) o;
        return Objects.equals(appointmentId, that.appointmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId);
    }


}
