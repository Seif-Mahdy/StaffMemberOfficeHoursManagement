package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_INDEXES", schema = "information_schema", catalog = "")
public class InnodbIndexesEntity {
    private Object indexId;
    private String name;
    private Object tableId;
    private int type;
    private int nFields;
    private int pageNo;
    private int space;
    private int mergeThreshold;

    @Basic
    @Column(name = "INDEX_ID")
    public Object getIndexId() {
        return indexId;
    }

    public void setIndexId(Object indexId) {
        this.indexId = indexId;
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
    @Column(name = "TABLE_ID")
    public Object getTableId() {
        return tableId;
    }

    public void setTableId(Object tableId) {
        this.tableId = tableId;
    }

    @Basic
    @Column(name = "TYPE")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "N_FIELDS")
    public int getnFields() {
        return nFields;
    }

    public void setnFields(int nFields) {
        this.nFields = nFields;
    }

    @Basic
    @Column(name = "PAGE_NO")
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Basic
    @Column(name = "SPACE")
    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    @Basic
    @Column(name = "MERGE_THRESHOLD")
    public int getMergeThreshold() {
        return mergeThreshold;
    }

    public void setMergeThreshold(int mergeThreshold) {
        this.mergeThreshold = mergeThreshold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbIndexesEntity that = (InnodbIndexesEntity) o;
        return type == that.type && nFields == that.nFields && pageNo == that.pageNo && space == that.space && mergeThreshold == that.mergeThreshold && Objects.equals(indexId, that.indexId) && Objects.equals(name, that.name) && Objects.equals(tableId, that.tableId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexId, name, tableId, type, nFields, pageNo, space, mergeThreshold);
    }
}
