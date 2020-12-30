package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "COLUMN_STATISTICS", schema = "information_schema", catalog = "")
public class ColumnStatisticsEntity {
    private String schemaName;
    private String tableName;
    private String columnName;
    private Object histogram;

    @Basic
    @Column(name = "SCHEMA_NAME")
    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    @Basic
    @Column(name = "TABLE_NAME")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "COLUMN_NAME")
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Basic
    @Column(name = "HISTOGRAM")
    public Object getHistogram() {
        return histogram;
    }

    public void setHistogram(Object histogram) {
        this.histogram = histogram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnStatisticsEntity that = (ColumnStatisticsEntity) o;
        return Objects.equals(schemaName, that.schemaName) && Objects.equals(tableName, that.tableName) && Objects.equals(columnName, that.columnName) && Objects.equals(histogram, that.histogram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schemaName, tableName, columnName, histogram);
    }
}
