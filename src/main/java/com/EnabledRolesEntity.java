package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ENABLED_ROLES", schema = "information_schema", catalog = "")
public class EnabledRolesEntity {
    private String roleName;
    private String roleHost;
    private String isDefault;
    private String isMandatory;

    @Basic
    @Column(name = "ROLE_NAME")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "ROLE_HOST")
    public String getRoleHost() {
        return roleHost;
    }

    public void setRoleHost(String roleHost) {
        this.roleHost = roleHost;
    }

    @Basic
    @Column(name = "IS_DEFAULT")
    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Basic
    @Column(name = "IS_MANDATORY")
    public String getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(String isMandatory) {
        this.isMandatory = isMandatory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnabledRolesEntity that = (EnabledRolesEntity) o;
        return Objects.equals(roleName, that.roleName) && Objects.equals(roleHost, that.roleHost) && Objects.equals(isDefault, that.isDefault) && Objects.equals(isMandatory, that.isMandatory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName, roleHost, isDefault, isMandatory);
    }
}
