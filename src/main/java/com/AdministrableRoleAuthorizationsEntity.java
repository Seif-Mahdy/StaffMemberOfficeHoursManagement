package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ADMINISTRABLE_ROLE_AUTHORIZATIONS", schema = "information_schema", catalog = "")
public class AdministrableRoleAuthorizationsEntity {
    private String user;
    private String host;
    private String grantee;
    private String granteeHost;
    private String roleName;
    private String roleHost;
    private String isGrantable;
    private String isDefault;
    private String isMandatory;

    @Basic
    @Column(name = "USER")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "HOST")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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
    @Column(name = "IS_GRANTABLE")
    public String getIsGrantable() {
        return isGrantable;
    }

    public void setIsGrantable(String isGrantable) {
        this.isGrantable = isGrantable;
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
        AdministrableRoleAuthorizationsEntity that = (AdministrableRoleAuthorizationsEntity) o;
        return Objects.equals(user, that.user) && Objects.equals(host, that.host) && Objects.equals(grantee, that.grantee) && Objects.equals(granteeHost, that.granteeHost) && Objects.equals(roleName, that.roleName) && Objects.equals(roleHost, that.roleHost) && Objects.equals(isGrantable, that.isGrantable) && Objects.equals(isDefault, that.isDefault) && Objects.equals(isMandatory, that.isMandatory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, host, grantee, granteeHost, roleName, roleHost, isGrantable, isDefault, isMandatory);
    }
}
