package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "TABLE_CONSTRAINTS", schema = "information_schema", catalog = "")
public class TableConstraintsEntity {
    private String constraintCatalog;
    private String constraintSchema;
    private String constraintName;
    private String tableSchema;
    private String tableName;
    private String constraintType;
    private String enforced;

    @Basic
    @Column(name = "CONSTRAINT_CATALOG")
    public String getConstraintCatalog() {
        return constraintCatalog;
    }

    public void setConstraintCatalog(String constraintCatalog) {
        this.constraintCatalog = constraintCatalog;
    }

    @Basic
    @Column(name = "CONSTRAINT_SCHEMA")
    public String getConstraintSchema() {
        return constraintSchema;
    }

    public void setConstraintSchema(String constraintSchema) {
        this.constraintSchema = constraintSchema;
    }

    @Basic
    @Column(name = "CONSTRAINT_NAME")
    public String getConstraintName() {
        return constraintName;
    }

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName;
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
    @Column(name = "CONSTRAINT_TYPE")
    public String getConstraintType() {
        return constraintType;
    }

    public void setConstraintType(String constraintType) {
        this.constraintType = constraintType;
    }

    @Basic
    @Column(name = "ENFORCED")
    public String getEnforced() {
        return enforced;
    }

    public void setEnforced(String enforced) {
        this.enforced = enforced;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableConstraintsEntity that = (TableConstraintsEntity) o;
        return Objects.equals(constraintCatalog, that.constraintCatalog) && Objects.equals(constraintSchema, that.constraintSchema) && Objects.equals(constraintName, that.constraintName) && Objects.equals(tableSchema, that.tableSchema) && Objects.equals(tableName, that.tableName) && Objects.equals(constraintType, that.constraintType) && Objects.equals(enforced, that.enforced);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constraintCatalog, constraintSchema, constraintName, tableSchema, tableName, constraintType, enforced);
    }
}
