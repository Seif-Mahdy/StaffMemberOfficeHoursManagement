package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "staffmember", schema = "officehoursmangementsystem")
public class StaffmemberEntity {
    private String staffId;
    private String staffName;
    private String staffNumber;
    private String staffEmail;
    private String staffPassword;
    private String staffRole;

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
    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffemail) {
        this.staffEmail = staffemail;
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
    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffmemberEntity that = (StaffmemberEntity) o;
        return Objects.equals(staffId, that.staffId) && Objects.equals(staffName, that.staffName) && Objects.equals(staffNumber, that.staffNumber) && Objects.equals(staffEmail, that.staffEmail) && Objects.equals(staffPassword, that.staffPassword) && Objects.equals(staffRole, that.staffRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, staffName, staffNumber, staffEmail, staffPassword, staffRole);
    }
}
