package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_CACHED_INDEXES", schema = "information_schema", catalog = "")
public class InnodbCachedIndexesEntity {
    private Object spaceId;
    private Object indexId;
    private Object nCachedPages;

    @Basic
    @Column(name = "SPACE_ID")
    public Object getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Object spaceId) {
        this.spaceId = spaceId;
    }

    @Basic
    @Column(name = "INDEX_ID")
    public Object getIndexId() {
        return indexId;
    }

    public void setIndexId(Object indexId) {
        this.indexId = indexId;
    }

    @Basic
    @Column(name = "N_CACHED_PAGES")
    public Object getnCachedPages() {
        return nCachedPages;
    }

    public void setnCachedPages(Object nCachedPages) {
        this.nCachedPages = nCachedPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbCachedIndexesEntity that = (InnodbCachedIndexesEntity) o;
        return Objects.equals(spaceId, that.spaceId) && Objects.equals(indexId, that.indexId) && Objects.equals(nCachedPages, that.nCachedPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spaceId, indexId, nCachedPages);
    }
}
