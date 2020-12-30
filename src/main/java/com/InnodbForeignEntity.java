package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_FOREIGN", schema = "information_schema", catalog = "")
public class InnodbForeignEntity {
    private String id;
    private String forName;
    private String refName;
    private long nCols;
    private Object type;

    @Basic
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FOR_NAME")
    public String getForName() {
        return forName;
    }

    public void setForName(String forName) {
        this.forName = forName;
    }

    @Basic
    @Column(name = "REF_NAME")
    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    @Basic
    @Column(name = "N_COLS")
    public long getnCols() {
        return nCols;
    }

    public void setnCols(long nCols) {
        this.nCols = nCols;
    }

    @Basic
    @Column(name = "TYPE")
    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbForeignEntity that = (InnodbForeignEntity) o;
        return nCols == that.nCols && Objects.equals(id, that.id) && Objects.equals(forName, that.forName) && Objects.equals(refName, that.refName) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, forName, refName, nCols, type);
    }
}
