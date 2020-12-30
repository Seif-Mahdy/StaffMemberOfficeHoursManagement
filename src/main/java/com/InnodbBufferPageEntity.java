package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_BUFFER_PAGE", schema = "information_schema", catalog = "")
public class InnodbBufferPageEntity {
    private Object poolId;
    private Object blockId;
    private Object space;
    private Object pageNumber;
    private String pageType;
    private Object flushType;
    private Object fixCount;
    private String isHashed;
    private Object newestModification;
    private Object oldestModification;
    private Object accessTime;
    private String tableName;
    private String indexName;
    private Object numberRecords;
    private Object dataSize;
    private Object compressedSize;
    private String pageState;
    private String ioFix;
    private String isOld;
    private Object freePageClock;

    @Basic
    @Column(name = "POOL_ID")
    public Object getPoolId() {
        return poolId;
    }

    public void setPoolId(Object poolId) {
        this.poolId = poolId;
    }

    @Basic
    @Column(name = "BLOCK_ID")
    public Object getBlockId() {
        return blockId;
    }

    public void setBlockId(Object blockId) {
        this.blockId = blockId;
    }

    @Basic
    @Column(name = "SPACE")
    public Object getSpace() {
        return space;
    }

    public void setSpace(Object space) {
        this.space = space;
    }

    @Basic
    @Column(name = "PAGE_NUMBER")
    public Object getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Object pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Basic
    @Column(name = "PAGE_TYPE")
    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    @Basic
    @Column(name = "FLUSH_TYPE")
    public Object getFlushType() {
        return flushType;
    }

    public void setFlushType(Object flushType) {
        this.flushType = flushType;
    }

    @Basic
    @Column(name = "FIX_COUNT")
    public Object getFixCount() {
        return fixCount;
    }

    public void setFixCount(Object fixCount) {
        this.fixCount = fixCount;
    }

    @Basic
    @Column(name = "IS_HASHED")
    public String getIsHashed() {
        return isHashed;
    }

    public void setIsHashed(String isHashed) {
        this.isHashed = isHashed;
    }

    @Basic
    @Column(name = "NEWEST_MODIFICATION")
    public Object getNewestModification() {
        return newestModification;
    }

    public void setNewestModification(Object newestModification) {
        this.newestModification = newestModification;
    }

    @Basic
    @Column(name = "OLDEST_MODIFICATION")
    public Object getOldestModification() {
        return oldestModification;
    }

    public void setOldestModification(Object oldestModification) {
        this.oldestModification = oldestModification;
    }

    @Basic
    @Column(name = "ACCESS_TIME")
    public Object getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Object accessTime) {
        this.accessTime = accessTime;
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
    @Column(name = "INDEX_NAME")
    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    @Basic
    @Column(name = "NUMBER_RECORDS")
    public Object getNumberRecords() {
        return numberRecords;
    }

    public void setNumberRecords(Object numberRecords) {
        this.numberRecords = numberRecords;
    }

    @Basic
    @Column(name = "DATA_SIZE")
    public Object getDataSize() {
        return dataSize;
    }

    public void setDataSize(Object dataSize) {
        this.dataSize = dataSize;
    }

    @Basic
    @Column(name = "COMPRESSED_SIZE")
    public Object getCompressedSize() {
        return compressedSize;
    }

    public void setCompressedSize(Object compressedSize) {
        this.compressedSize = compressedSize;
    }

    @Basic
    @Column(name = "PAGE_STATE")
    public String getPageState() {
        return pageState;
    }

    public void setPageState(String pageState) {
        this.pageState = pageState;
    }

    @Basic
    @Column(name = "IO_FIX")
    public String getIoFix() {
        return ioFix;
    }

    public void setIoFix(String ioFix) {
        this.ioFix = ioFix;
    }

    @Basic
    @Column(name = "IS_OLD")
    public String getIsOld() {
        return isOld;
    }

    public void setIsOld(String isOld) {
        this.isOld = isOld;
    }

    @Basic
    @Column(name = "FREE_PAGE_CLOCK")
    public Object getFreePageClock() {
        return freePageClock;
    }

    public void setFreePageClock(Object freePageClock) {
        this.freePageClock = freePageClock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbBufferPageEntity that = (InnodbBufferPageEntity) o;
        return Objects.equals(poolId, that.poolId) && Objects.equals(blockId, that.blockId) && Objects.equals(space, that.space) && Objects.equals(pageNumber, that.pageNumber) && Objects.equals(pageType, that.pageType) && Objects.equals(flushType, that.flushType) && Objects.equals(fixCount, that.fixCount) && Objects.equals(isHashed, that.isHashed) && Objects.equals(newestModification, that.newestModification) && Objects.equals(oldestModification, that.oldestModification) && Objects.equals(accessTime, that.accessTime) && Objects.equals(tableName, that.tableName) && Objects.equals(indexName, that.indexName) && Objects.equals(numberRecords, that.numberRecords) && Objects.equals(dataSize, that.dataSize) && Objects.equals(compressedSize, that.compressedSize) && Objects.equals(pageState, that.pageState) && Objects.equals(ioFix, that.ioFix) && Objects.equals(isOld, that.isOld) && Objects.equals(freePageClock, that.freePageClock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poolId, blockId, space, pageNumber, pageType, flushType, fixCount, isHashed, newestModification, oldestModification, accessTime, tableName, indexName, numberRecords, dataSize, compressedSize, pageState, ioFix, isOld, freePageClock);
    }
}
