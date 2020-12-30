package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "VIEW_TABLE_USAGE", schema = "information_schema", catalog = "")
public class ViewTableUsageEntity {
    private String viewCatalog;
    private String viewSchema;
    private String viewName;
    private String tableCatalog;
    private String tableSchema;
    private String tableName;

    @Basic
    @Column(name = "VIEW_CATALOG")
    public String getViewCatalog() {
        return viewCatalog;
    }

    public void setViewCatalog(String viewCatalog) {
        this.viewCatalog = viewCatalog;
    }

    @Basic
    @Column(name = "VIEW_SCHEMA")
    public String getViewSchema() {
        return viewSchema;
    }

    public void setViewSchema(String viewSchema) {
        this.viewSchema = viewSchema;
    }

    @Basic
    @Column(name = "VIEW_NAME")
    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewTableUsageEntity that = (ViewTableUsageEntity) o;
        return Objects.equals(viewCatalog, that.viewCatalog) && Objects.equals(viewSchema, that.viewSchema) && Objects.equals(viewName, that.viewName) && Objects.equals(tableCatalog, that.tableCatalog) && Objects.equals(tableSchema, that.tableSchema) && Objects.equals(tableName, that.tableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viewCatalog, viewSchema, viewName, tableCatalog, tableSchema, tableName);
    }
}
