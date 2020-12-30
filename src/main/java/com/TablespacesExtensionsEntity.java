package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "TABLESPACES_EXTENSIONS", schema = "information_schema", catalog = "")
public class TablespacesExtensionsEntity {
    private String tablespaceName;
    private Object engineAttribute;

    @Basic
    @Column(name = "TABLESPACE_NAME")
    public String getTablespaceName() {
        return tablespaceName;
    }

    public void setTablespaceName(String tablespaceName) {
        this.tablespaceName = tablespaceName;
    }

    @Basic
    @Column(name = "ENGINE_ATTRIBUTE")
    public Object getEngineAttribute() {
        return engineAttribute;
    }

    public void setEngineAttribute(Object engineAttribute) {
        this.engineAttribute = engineAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TablespacesExtensionsEntity that = (TablespacesExtensionsEntity) o;
        return Objects.equals(tablespaceName, that.tablespaceName) && Objects.equals(engineAttribute, that.engineAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tablespaceName, engineAttribute);
    }
}
