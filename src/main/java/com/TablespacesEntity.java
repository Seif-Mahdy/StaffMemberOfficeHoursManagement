package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "TABLESPACES", schema = "information_schema", catalog = "")
public class TablespacesEntity {
    private String tablespaceName;
    private String engine;
    private String tablespaceType;
    private String logfileGroupName;
    private Object extentSize;
    private Object autoextendSize;
    private Object maximumSize;
    private Object nodegroupId;
    private String tablespaceComment;

    @Basic
    @Column(name = "TABLESPACE_NAME")
    public String getTablespaceName() {
        return tablespaceName;
    }

    public void setTablespaceName(String tablespaceName) {
        this.tablespaceName = tablespaceName;
    }

    @Basic
    @Column(name = "ENGINE")
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Basic
    @Column(name = "TABLESPACE_TYPE")
    public String getTablespaceType() {
        return tablespaceType;
    }

    public void setTablespaceType(String tablespaceType) {
        this.tablespaceType = tablespaceType;
    }

    @Basic
    @Column(name = "LOGFILE_GROUP_NAME")
    public String getLogfileGroupName() {
        return logfileGroupName;
    }

    public void setLogfileGroupName(String logfileGroupName) {
        this.logfileGroupName = logfileGroupName;
    }

    @Basic
    @Column(name = "EXTENT_SIZE")
    public Object getExtentSize() {
        return extentSize;
    }

    public void setExtentSize(Object extentSize) {
        this.extentSize = extentSize;
    }

    @Basic
    @Column(name = "AUTOEXTEND_SIZE")
    public Object getAutoextendSize() {
        return autoextendSize;
    }

    public void setAutoextendSize(Object autoextendSize) {
        this.autoextendSize = autoextendSize;
    }

    @Basic
    @Column(name = "MAXIMUM_SIZE")
    public Object getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(Object maximumSize) {
        this.maximumSize = maximumSize;
    }

    @Basic
    @Column(name = "NODEGROUP_ID")
    public Object getNodegroupId() {
        return nodegroupId;
    }

    public void setNodegroupId(Object nodegroupId) {
        this.nodegroupId = nodegroupId;
    }

    @Basic
    @Column(name = "TABLESPACE_COMMENT")
    public String getTablespaceComment() {
        return tablespaceComment;
    }

    public void setTablespaceComment(String tablespaceComment) {
        this.tablespaceComment = tablespaceComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TablespacesEntity that = (TablespacesEntity) o;
        return Objects.equals(tablespaceName, that.tablespaceName) && Objects.equals(engine, that.engine) && Objects.equals(tablespaceType, that.tablespaceType) && Objects.equals(logfileGroupName, that.logfileGroupName) && Objects.equals(extentSize, that.extentSize) && Objects.equals(autoextendSize, that.autoextendSize) && Objects.equals(maximumSize, that.maximumSize) && Objects.equals(nodegroupId, that.nodegroupId) && Objects.equals(tablespaceComment, that.tablespaceComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tablespaceName, engine, tablespaceType, logfileGroupName, extentSize, autoextendSize, maximumSize, nodegroupId, tablespaceComment);
    }
}
