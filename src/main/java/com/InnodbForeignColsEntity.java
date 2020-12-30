package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_FOREIGN_COLS", schema = "information_schema", catalog = "")
public class InnodbForeignColsEntity {
    private String id;
    private String forColName;
    private String refColName;
    private Object pos;

    @Basic
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FOR_COL_NAME")
    public String getForColName() {
        return forColName;
    }

    public void setForColName(String forColName) {
        this.forColName = forColName;
    }

    @Basic
    @Column(name = "REF_COL_NAME")
    public String getRefColName() {
        return refColName;
    }

    public void setRefColName(String refColName) {
        this.refColName = refColName;
    }

    @Basic
    @Column(name = "POS")
    public Object getPos() {
        return pos;
    }

    public void setPos(Object pos) {
        this.pos = pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbForeignColsEntity that = (InnodbForeignColsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(forColName, that.forColName) && Objects.equals(refColName, that.refColName) && Objects.equals(pos, that.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, forColName, refColName, pos);
    }
}
