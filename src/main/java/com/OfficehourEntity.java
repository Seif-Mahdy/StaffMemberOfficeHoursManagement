package com;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "officeHour", schema = "officehoursmangementsystem")
public class OfficehourEntity {
    private Integer id;
    private Date fromDate;
    private Date toDate;
    private Byte isOffline;
    private String location;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "From_Date")
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "To_Date")
    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
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
