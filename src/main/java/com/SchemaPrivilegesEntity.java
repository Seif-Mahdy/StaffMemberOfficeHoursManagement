package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "SCHEMA_PRIVILEGES", schema = "information_schema", catalog = "")
public class SchemaPrivilegesEntity {
    private String grantee;
    private String tableCatalog;
    private String tableSchema;
    private String privilegeType;
    private String isGrantable;

    @Basic
    @Column(name = "GRANTEE")
    public String getGrantee() {
        return grantee;
    }

    public void setGrantee(String grantee) {
        this.grantee = grantee;
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
    @Column(name = "PRIVILEGE_TYPE")
    public String getPrivilegeType() {
        return privilegeType;
    }

    public void setPrivilegeType(String privilegeType) {
        this.privilegeType = privilegeType;
    }

    @Basic
    @Column(name = "IS_GRANTABLE")
    public String getIsGrantable() {
        return isGrantable;
    }

    public void setIsGrantable(String isGrantable) {
        this.isGrantable = isGrantable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchemaPrivilegesEntity that = (SchemaPrivilegesEntity) o;
        return Objects.equals(grantee, that.grantee) && Objects.equals(tableCatalog, that.tableCatalog) && Objects.equals(tableSchema, that.tableSchema) && Objects.equals(privilegeType, that.privilegeType) && Objects.equals(isGrantable, that.isGrantable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grantee, tableCatalog, tableSchema, privilegeType, isGrantable);
    }
}
