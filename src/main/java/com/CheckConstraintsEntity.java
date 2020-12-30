package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CHECK_CONSTRAINTS", schema = "information_schema", catalog = "")
public class CheckConstraintsEntity {
    private String constraintCatalog;
    private String constraintSchema;
    private String constraintName;
    private String checkClause;

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
    @Column(name = "CHECK_CLAUSE")
    public String getCheckClause() {
        return checkClause;
    }

    public void setCheckClause(String checkClause) {
        this.checkClause = checkClause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckConstraintsEntity that = (CheckConstraintsEntity) o;
        return Objects.equals(constraintCatalog, that.constraintCatalog) && Objects.equals(constraintSchema, that.constraintSchema) && Objects.equals(constraintName, that.constraintName) && Objects.equals(checkClause, that.checkClause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constraintCatalog, constraintSchema, constraintName, checkClause);
    }
}
