package com;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "officehour", schema = "officehoursmangementsystem")
public class OfficehourEntity {
    private Integer id;
    private Timestamp fromDate;
    private Timestamp toDate;
    private Byte isOffline;
    private String location;
    private String staffId;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    public Integer getId() {
        return id;
    }
    private void setId(int id){this.id=id;}


    @Basic
    @Column(name = "From_Date")
    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "To_Date")
    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    @Basic
    @Column(name = "IsOffline")
    public Byte getIsOffline() {
        return isOffline;
    }

    public void setIsOffline(Byte isOffline) {
        this.isOffline = isOffline;
    }

    @Basic
    @Column(name = "Location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        OfficehourEntity that = (OfficehourEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(fromDate, that.fromDate) && Objects.equals(toDate, that.toDate) && Objects.equals(isOffline, that.isOffline) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromDate, toDate, isOffline, location);
    }
}
