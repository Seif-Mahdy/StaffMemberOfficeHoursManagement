package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "COLUMNS_EXTENSIONS", schema = "information_schema", catalog = "")
public class ColumnsExtensionsEntity {
    private String tableCatalog;
    private String tableSchema;
    private String tableName;
    private String columnName;
    private Object engineAttribute;
    private Object secondaryEngineAttribute;

    @Basic
    @Column(name = "TABLE_CATALOG")
    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }

    @Basic
    @Column(name = "TABLE_SCHEMA")
    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
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
    @Column(name = "ENGINE_ATTRIBUTE")
    public Object getEngineAttribute() {
        return engineAttribute;
    }

    public void setEngineAttribute(Object engineAttribute) {
        this.engineAttribute = engineAttribute;
    }

    @Basic
    @Column(name = "SECONDARY_ENGINE_ATTRIBUTE")
    public Object getSecondaryEngineAttribute() {
        return secondaryEngineAttribute;
    }

    public void setSecondaryEngineAttribute(Object secondaryEngineAttribute) {
        this.secondaryEngineAttribute = secondaryEngineAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnsExtensionsEntity that = (ColumnsExtensionsEntity) o;
        return Objects.equals(tableCatalog, that.tableCatalog) && Objects.equals(tableSchema, that.tableSchema) && Objects.equals(tableName, that.tableName) && Objects.equals(columnName, that.columnName) && Objects.equals(engineAttribute, that.engineAttribute) && Objects.equals(secondaryEngineAttribute, that.secondaryEngineAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableCatalog, tableSchema, tableName, columnName, engineAttribute, secondaryEngineAttribute);
    }
}
