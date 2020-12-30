package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_TEMP_TABLE_INFO", schema = "information_schema", catalog = "")
public class InnodbTempTableInfoEntity {
    private Object tableId;
    private String name;
    private Object nCols;
    private Object space;

    @Basic
    @Column(name = "TABLE_ID")
    public Object getTableId() {
        return tableId;
    }

    public void setTableId(Object tableId) {
        this.tableId = tableId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "N_COLS")
    public Object getnCols() {
        return nCols;
    }

    public void setnCols(Object nCols) {
        this.nCols = nCols;
    }

    @Basic
    @Column(name = "SPACE")
    public Object getSpace() {
        return space;
    }

    public void setSpace(Object space) {
        this.space = space;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbTempTableInfoEntity that = (InnodbTempTableInfoEntity) o;
        return Objects.equals(tableId, that.tableId) && Objects.equals(name, that.name) && Objects.equals(nCols, that.nCols) && Objects.equals(space, that.space);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableId, name, nCols, space);
    }
}
