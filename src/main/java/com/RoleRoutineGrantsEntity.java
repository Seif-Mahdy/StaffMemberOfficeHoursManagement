package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ROLE_ROUTINE_GRANTS", schema = "information_schema", catalog = "")
public class RoleRoutineGrantsEntity {
    private String grantor;
    private String grantorHost;
    private String grantee;
    private String granteeHost;
    private String specificCatalog;
    private String specificSchema;
    private String specificName;
    private String routineCatalog;
    private String routineSchema;
    private String routineName;
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
    @Column(name = "SPECIFIC_CATALOG")
    public String getSpecificCatalog() {
        return specificCatalog;
    }

    public void setSpecificCatalog(String specificCatalog) {
        this.specificCatalog = specificCatalog;
    }

    @Basic
    @Column(name = "SPECIFIC_SCHEMA")
    public String getSpecificSchema() {
        return specificSchema;
    }

    public void setSpecificSchema(String specificSchema) {
        this.specificSchema = specificSchema;
    }

    @Basic
    @Column(name = "SPECIFIC_NAME")
    public String getSpecificName() {
        return specificName;
    }

    public void setSpecificName(String specificName) {
        this.specificName = specificName;
    }

    @Basic
    @Column(name = "ROUTINE_CATALOG")
    public String getRoutineCatalog() {
        return routineCatalog;
    }

    public void setRoutineCatalog(String routineCatalog) {
        this.routineCatalog = routineCatalog;
    }

    @Basic
    @Column(name = "ROUTINE_SCHEMA")
    public String getRoutineSchema() {
        return routineSchema;
    }

    public void setRoutineSchema(String routineSchema) {
        this.routineSchema = routineSchema;
    }

    @Basic
    @Column(name = "ROUTINE_NAME")
    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
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
        RoleRoutineGrantsEntity that = (RoleRoutineGrantsEntity) o;
        return Objects.equals(grantor, that.grantor) && Objects.equals(grantorHost, that.grantorHost) && Objects.equals(grantee, that.grantee) && Objects.equals(granteeHost, that.granteeHost) && Objects.equals(specificCatalog, that.specificCatalog) && Objects.equals(specificSchema, that.specificSchema) && Objects.equals(specificName, that.specificName) && Objects.equals(routineCatalog, that.routineCatalog) && Objects.equals(routineSchema, that.routineSchema) && Objects.equals(routineName, that.routineName) && Objects.equals(privilegeType, that.privilegeType) && Objects.equals(isGrantable, that.isGrantable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grantor, grantorHost, grantee, granteeHost, specificCatalog, specificSchema, specificName, routineCatalog, routineSchema, routineName, privilegeType, isGrantable);
    }
}
