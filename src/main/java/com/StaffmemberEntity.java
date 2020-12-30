package com;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "staffmember", schema = "officehoursmangementsystem", catalog = "")
public class StaffmemberEntity {
    private String staffId;
    private String staffName;
    private String staffNumber;
    private String staffemail;
    private String staffPassword;
    private Byte staffRole;
    private Collection<AppointmentEntity> appointmentsByStaffId;
    private Collection<CoursetostaffEntity> coursetostaffsByStaffId;
    private Collection<MessageEntity> messagesByStaffId;

    @Id
    @Column(name = "StaffId")
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "StaffName")
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Basic
    @Column(name = "StaffNumber")
    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    @Basic
    @Column(name = "Staffemail")
    public String getStaffemail() {
        return staffemail;
    }

    public void setStaffemail(String staffemail) {
        this.staffemail = staffemail;
    }

    @Basic
    @Column(name = "StaffPassword")
    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    @Basic
    @Column(name = "StaffRole")
    public Byte getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(Byte staffRole) {
        this.staffRole = staffRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffmemberEntity that = (StaffmemberEntity) o;
        return Objects.equals(staffId, that.staffId) && Objects.equals(staffName, that.staffName) && Objects.equals(staffNumber, that.staffNumber) && Objects.equals(staffemail, that.staffemail) && Objects.equals(staffPassword, that.staffPassword) && Objects.equals(staffRole, that.staffRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, staffName, staffNumber, staffemail, staffPassword, staffRole);
    }

    @OneToMany(mappedBy = "staffmemberByStaffId")
    public Collection<AppointmentEntity> getAppointmentsByStaffId() {
        return appointmentsByStaffId;
    }

    public void setAppointmentsByStaffId(Collection<AppointmentEntity> appointmentsByStaffId) {
        this.appointmentsByStaffId = appointmentsByStaffId;
    }

    @OneToMany(mappedBy = "staffmemberByStaffId")
    public Collection<CoursetostaffEntity> getCoursetostaffsByStaffId() {
        return coursetostaffsByStaffId;
    }

    public void setCoursetostaffsByStaffId(Collection<CoursetostaffEntity> coursetostaffsByStaffId) {
        this.coursetostaffsByStaffId = coursetostaffsByStaffId;
    }

    @OneToMany(mappedBy = "staffmemberByStaffId")
    public Collection<MessageEntity> getMessagesByStaffId() {
        return messagesByStaffId;
    }

    public void setMessagesByStaffId(Collection<MessageEntity> messagesByStaffId) {
        this.messagesByStaffId = messagesByStaffId;
    }
}
