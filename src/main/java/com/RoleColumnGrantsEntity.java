package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ROLE_COLUMN_GRANTS", schema = "information_schema", catalog = "")
public class RoleColumnGrantsEntity {
    private String grantor;
    private String grantorHost;
    private String grantee;
    private String granteeHost;
    private String tableCatalog;
    private String tableSchema;
    private String tableName;
    private String columnName;
    private Object privilegeType;
    private String isGrantable;

    @Basic
    @Column(name = "GRANTOR")
    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    @Basic
    @Column(name = "GRANTOR_HOST")
    public String getGrantorHost() {
        return grantorHost;
    }

    public void setGrantorHost(String grantorHost) {
        this.grantorHost = grantorHost;
    }

    @Basic
    @Column(name = "GRANTEE")
    public String getGrantee() {
        return grantee;
    }

    public void setGrantee(String grantee) {
        this.grantee = grantee;
    }

    @Basic
    @Column(name = "GRANTEE_HOST")
    public String getGranteeHost() {
        return granteeHost;
    }

    public void setGranteeHost(String granteeHost) {
        this.granteeHost = granteeHost;
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

    @Basic
    @Column(name = "COLUMN_NAME")
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Basic
    @Column(name = "PRIVILEGE_TYPE")
    public Object getPrivilegeType() {
        return privilegeType;
    }

    public void setPrivilegeType(Object privilegeType) {
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
        RoleColumnGrantsEntity that = (RoleColumnGrantsEntity) o;
        return Objects.equals(grantor, that.grantor) && Objects.equals(grantorHost, that.grantorHost) && Objects.equals(grantee, that.grantee) && Objects.equals(granteeHost, that.granteeHost) && Objects.equals(tableCatalog, that.tableCatalog) && Objects.equals(tableSchema, that.tableSchema) && Objects.equals(tableName, that.tableName) && Objects.equals(columnName, that.columnName) && Objects.equals(privilegeType, that.privilegeType) && Objects.equals(isGrantable, that.isGrantable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grantor, grantorHost, grantee, granteeHost, tableCatalog, tableSchema, tableName, columnName, privilegeType, isGrantable);
    }
}
