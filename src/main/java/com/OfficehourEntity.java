package com;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "officehour", schema = "officehoursmangementsystem", catalog = "")
public class OfficehourEntity {
    private int id;
    private Date fromDate;
    private Date toDate;
    private byte isOffline;
    private String location;
    private Collection<AppointmentEntity> appointmentsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public byte getIsOffline() {
        return isOffline;
    }

    public void setIsOffline(byte isOffline) {
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
        return id == that.id && isOffline == that.isOffline && Objects.equals(fromDate, that.fromDate) && Objects.equals(toDate, that.toDate) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromDate, toDate, isOffline, location);
    }

    @OneToMany(mappedBy = "officehourByOfficeHourId")
    public Collection<AppointmentEntity> getAppointmentsById() {
        return appointmentsById;
    }

    public void setAppointmentsById(Collection<AppointmentEntity> appointmentsById) {
        this.appointmentsById = appointmentsById;
    }
}
