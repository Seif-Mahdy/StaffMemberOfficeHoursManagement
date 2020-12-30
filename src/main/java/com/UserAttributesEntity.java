package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "USER_ATTRIBUTES", schema = "information_schema", catalog = "")
public class UserAttributesEntity {
    private String user;
    private String host;
    private String attribute;

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
    @Column(name = "ATTRIBUTE")
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAttributesEntity that = (UserAttributesEntity) o;
        return Objects.equals(user, that.user) && Objects.equals(host, that.host) && Objects.equals(attribute, that.attribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, host, attribute);
    }
}
