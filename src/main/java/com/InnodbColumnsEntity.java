package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_COLUMNS", schema = "information_schema", catalog = "")
public class InnodbColumnsEntity {
    private Object tableId;
    private String name;
    private Object pos;
    private int mtype;
    private int prtype;
    private int len;
    private int hasDefault;
    private String defaultValue;

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
    @Column(name = "POS")
    public Object getPos() {
        return pos;
    }

    public void setPos(Object pos) {
        this.pos = pos;
    }

    @Basic
    @Column(name = "MTYPE")
    public int getMtype() {
        return mtype;
    }

    public void setMtype(int mtype) {
        this.mtype = mtype;
    }

    @Basic
    @Column(name = "PRTYPE")
    public int getPrtype() {
        return prtype;
    }

    public void setPrtype(int prtype) {
        this.prtype = prtype;
    }

    @Basic
    @Column(name = "LEN")
    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    @Basic
    @Column(name = "HAS_DEFAULT")
    public int getHasDefault() {
        return hasDefault;
    }

    public void setHasDefault(int hasDefault) {
        this.hasDefault = hasDefault;
    }

    @Basic
    @Column(name = "DEFAULT_VALUE")
    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbColumnsEntity that = (InnodbColumnsEntity) o;
        return mtype == that.mtype && prtype == that.prtype && len == that.len && hasDefault == that.hasDefault && Objects.equals(tableId, that.tableId) && Objects.equals(name, that.name) && Objects.equals(pos, that.pos) && Objects.equals(defaultValue, that.defaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableId, name, pos, mtype, prtype, len, hasDefault, defaultValue);
    }
}
