package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "INNODB_TABLESPACES_BRIEF", schema = "information_schema", catalog = "")
public class InnodbTablespacesBriefEntity {
    private byte[] space;
    private String name;
    private String path;
    private byte[] flag;
    private String spaceType;

    @Basic
    @Column(name = "SPACE")
    public byte[] getSpace() {
        return space;
    }

    public void setSpace(byte[] space) {
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
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "FLAG")
    public byte[] getFlag() {
        return flag;
    }

    public void setFlag(byte[] flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "SPACE_TYPE")
    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbTablespacesBriefEntity that = (InnodbTablespacesBriefEntity) o;
        return Arrays.equals(space, that.space) && Objects.equals(name, that.name) && Objects.equals(path, that.path) && Arrays.equals(flag, that.flag) && Objects.equals(spaceType, that.spaceType);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, path, spaceType);
        result = 31 * result + Arrays.hashCode(space);
        result = 31 * result + Arrays.hashCode(flag);
        return result;
    }
}
