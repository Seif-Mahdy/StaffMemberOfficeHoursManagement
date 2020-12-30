package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "TABLE_CONSTRAINTS_EXTENSIONS", schema = "information_schema", catalog = "")
public class TableConstraintsExtensionsEntity {
    private String constraintCatalog;
    private String constraintSchema;
    private String constraintName;
    private String tableName;
    private Object engineAttribute;
    private Object secondaryEngineAttribute;

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
    @Column(name = "TABLE_NAME")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
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
        TableConstraintsExtensionsEntity that = (TableConstraintsExtensionsEntity) o;
        return Objects.equals(constraintCatalog, that.constraintCatalog) && Objects.equals(constraintSchema, that.constraintSchema) && Objects.equals(constraintName, that.constraintName) && Objects.equals(tableName, that.tableName) && Objects.equals(engineAttribute, that.engineAttribute) && Objects.equals(secondaryEngineAttribute, that.secondaryEngineAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constraintCatalog, constraintSchema, constraintName, tableName, engineAttribute, secondaryEngineAttribute);
    }
}
