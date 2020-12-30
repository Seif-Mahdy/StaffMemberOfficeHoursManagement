package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_TABLESPACES", schema = "information_schema", catalog = "")
public class InnodbTablespacesEntity {
    private Object space;
    private String name;
    private Object flag;
    private String rowFormat;
    private Object pageSize;
    private Object zipPageSize;
    private String spaceType;
    private Object fsBlockSize;
    private Object fileSize;
    private Object allocatedSize;
    private String serverVersion;
    private Object spaceVersion;
    private String encryption;
    private String state;

    @Basic
    @Column(name = "SPACE")
    public Object getSpace() {
        return space;
    }

    public void setSpace(Object space) {
        this.space = space;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "FLAG")
    public Object getFlag() {
        return flag;
    }

    public void setFlag(Object flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "ROW_FORMAT")
    public String getRowFormat() {
        return rowFormat;
    }

    public void setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat;
    }

    @Basic
    @Column(name = "PAGE_SIZE")
    public Object getPageSize() {
        return pageSize;
    }

    public void setPageSize(Object pageSize) {
        this.pageSize = pageSize;
    }

    @Basic
    @Column(name = "ZIP_PAGE_SIZE")
    public Object getZipPageSize() {
        return zipPageSize;
    }

    public void setZipPageSize(Object zipPageSize) {
        this.zipPageSize = zipPageSize;
    }

    @Basic
    @Column(name = "SPACE_TYPE")
    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    @Basic
    @Column(name = "FS_BLOCK_SIZE")
    public Object getFsBlockSize() {
        return fsBlockSize;
    }

    public void setFsBlockSize(Object fsBlockSize) {
        this.fsBlockSize = fsBlockSize;
    }

    @Basic
    @Column(name = "FILE_SIZE")
    public Object getFileSize() {
        return fileSize;
    }

    public void setFileSize(Object fileSize) {
        this.fileSize = fileSize;
    }

    @Basic
    @Column(name = "ALLOCATED_SIZE")
    public Object getAllocatedSize() {
        return allocatedSize;
    }

    public void setAllocatedSize(Object allocatedSize) {
        this.allocatedSize = allocatedSize;
    }

    @Basic
    @Column(name = "SERVER_VERSION")
    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    @Basic
    @Column(name = "SPACE_VERSION")
    public Object getSpaceVersion() {
        return spaceVersion;
    }

    public void setSpaceVersion(Object spaceVersion) {
        this.spaceVersion = spaceVersion;
    }

    @Basic
    @Column(name = "ENCRYPTION")
    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    @Basic
    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbTablespacesEntity that = (InnodbTablespacesEntity) o;
        return Objects.equals(space, that.space) && Objects.equals(name, that.name) && Objects.equals(flag, that.flag) && Objects.equals(rowFormat, that.rowFormat) && Objects.equals(pageSize, that.pageSize) && Objects.equals(zipPageSize, that.zipPageSize) && Objects.equals(spaceType, that.spaceType) && Objects.equals(fsBlockSize, that.fsBlockSize) && Objects.equals(fileSize, that.fileSize) && Objects.equals(allocatedSize, that.allocatedSize) && Objects.equals(serverVersion, that.serverVersion) && Objects.equals(spaceVersion, that.spaceVersion) && Objects.equals(encryption, that.encryption) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(space, name, flag, rowFormat, pageSize, zipPageSize, spaceType, fsBlockSize, fileSize, allocatedSize, serverVersion, spaceVersion, encryption, state);
    }
}
