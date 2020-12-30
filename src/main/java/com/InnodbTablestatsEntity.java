package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_TABLESTATS", schema = "information_schema", catalog = "")
public class InnodbTablestatsEntity {
    private Object tableId;
    private String name;
    private String statsInitialized;
    private Object numRows;
    private Object clustIndexSize;
    private Object otherIndexSize;
    private Object modifiedCounter;
    private Object autoinc;
    private int refCount;

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
    @Column(name = "STATS_INITIALIZED")
    public String getStatsInitialized() {
        return statsInitialized;
    }

    public void setStatsInitialized(String statsInitialized) {
        this.statsInitialized = statsInitialized;
    }

    @Basic
    @Column(name = "NUM_ROWS")
    public Object getNumRows() {
        return numRows;
    }

    public void setNumRows(Object numRows) {
        this.numRows = numRows;
    }

    @Basic
    @Column(name = "CLUST_INDEX_SIZE")
    public Object getClustIndexSize() {
        return clustIndexSize;
    }

    public void setClustIndexSize(Object clustIndexSize) {
        this.clustIndexSize = clustIndexSize;
    }

    @Basic
    @Column(name = "OTHER_INDEX_SIZE")
    public Object getOtherIndexSize() {
        return otherIndexSize;
    }

    public void setOtherIndexSize(Object otherIndexSize) {
        this.otherIndexSize = otherIndexSize;
    }

    @Basic
    @Column(name = "MODIFIED_COUNTER")
    public Object getModifiedCounter() {
        return modifiedCounter;
    }

    public void setModifiedCounter(Object modifiedCounter) {
        this.modifiedCounter = modifiedCounter;
    }

    @Basic
    @Column(name = "AUTOINC")
    public Object getAutoinc() {
        return autoinc;
    }

    public void setAutoinc(Object autoinc) {
        this.autoinc = autoinc;
    }

    @Basic
    @Column(name = "REF_COUNT")
    public int getRefCount() {
        return refCount;
    }

    public void setRefCount(int refCount) {
        this.refCount = refCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbTablestatsEntity that = (InnodbTablestatsEntity) o;
        return refCount == that.refCount && Objects.equals(tableId, that.tableId) && Objects.equals(name, that.name) && Objects.equals(statsInitialized, that.statsInitialized) && Objects.equals(numRows, that.numRows) && Objects.equals(clustIndexSize, that.clustIndexSize) && Objects.equals(otherIndexSize, that.otherIndexSize) && Objects.equals(modifiedCounter, that.modifiedCounter) && Objects.equals(autoinc, that.autoinc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableId, name, statsInitialized, numRows, clustIndexSize, otherIndexSize, modifiedCounter, autoinc, refCount);
    }
}
