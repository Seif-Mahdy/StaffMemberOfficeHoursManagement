package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_VIRTUAL", schema = "information_schema", catalog = "")
public class InnodbVirtualEntity {
    private Object tableId;
    private Object pos;
    private Object basePos;

    @Basic
    @Column(name = "TABLE_ID")
    public Object getTableId() {
        return tableId;
    }

    public void setTableId(Object tableId) {
        this.tableId = tableId;
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
    @Column(name = "BASE_POS")
    public Object getBasePos() {
        return basePos;
    }

    public void setBasePos(Object basePos) {
        this.basePos = basePos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbVirtualEntity that = (InnodbVirtualEntity) o;
        return Objects.equals(tableId, that.tableId) && Objects.equals(pos, that.pos) && Objects.equals(basePos, that.basePos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableId, pos, basePos);
    }
}
