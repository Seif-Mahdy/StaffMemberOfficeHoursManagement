package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_SESSION_TEMP_TABLESPACES", schema = "information_schema", catalog = "")
public class InnodbSessionTempTablespacesEntity {
    private Object id;
    private Object space;
    private String path;
    private Object size;
    private String state;
    private String purpose;

    @Basic
    @Column(name = "ID")
    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SPACE")
    public Object getSpace() {
        return space;
    }

    public void setSpace(Object space) {
        this.space = space;
    }

    @Basic
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "SIZE")
    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    @Basic
    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "PURPOSE")
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbSessionTempTablespacesEntity that = (InnodbSessionTempTablespacesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(space, that.space) && Objects.equals(path, that.path) && Objects.equals(size, that.size) && Objects.equals(state, that.state) && Objects.equals(purpose, that.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, space, path, size, state, purpose);
    }
}
