package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_BUFFER_POOL_STATS", schema = "information_schema", catalog = "")
public class InnodbBufferPoolStatsEntity {
    private Object poolId;
    private Object poolSize;
    private Object freeBuffers;
    private Object databasePages;
    private Object oldDatabasePages;
    private Object modifiedDatabasePages;
    private Object pendingDecompress;
    private Object pendingReads;
    private Object pendingFlushLru;
    private Object pendingFlushList;
    private Object pagesMadeYoung;
    private Object pagesNotMadeYoung;
    private double pagesMadeYoungRate;
    private double pagesMadeNotYoungRate;
    private Object numberPagesRead;
    private Object numberPagesCreated;
    private Object numberPagesWritten;
    private double pagesReadRate;
    private double pagesCreateRate;
    private double pagesWrittenRate;
    private Object numberPagesGet;
    private Object hitRate;
    private Object youngMakePerThousandGets;
    private Object notYoungMakePerThousandGets;
    private Object numberPagesReadAhead;
    private Object numberReadAheadEvicted;
    private double readAheadRate;
    private double readAheadEvictedRate;
    private Object lruIoTotal;
    private Object lruIoCurrent;
    private Object uncompressTotal;
    private Object uncompressCurrent;

    @Basic
    @Column(name = "POOL_ID")
    public Object getPoolId() {
        return poolId;
    }

    public void setPoolId(Object poolId) {
        this.poolId = poolId;
    }

    @Basic
    @Column(name = "POOL_SIZE")
    public Object getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Object poolSize) {
        this.poolSize = poolSize;
    }

    @Basic
    @Column(name = "FREE_BUFFERS")
    public Object getFreeBuffers() {
        return freeBuffers;
    }

    public void setFreeBuffers(Object freeBuffers) {
        this.freeBuffers = freeBuffers;
    }

    @Basic
    @Column(name = "DATABASE_PAGES")
    public Object getDatabasePages() {
        return databasePages;
    }

    public void setDatabasePages(Object databasePages) {
        this.databasePages = databasePages;
    }

    @Basic
    @Column(name = "OLD_DATABASE_PAGES")
    public Object getOldDatabasePages() {
        return oldDatabasePages;
    }

    public void setOldDatabasePages(Object oldDatabasePages) {
        this.oldDatabasePages = oldDatabasePages;
    }

    @Basic
    @Column(name = "MODIFIED_DATABASE_PAGES")
    public Object getModifiedDatabasePages() {
        return modifiedDatabasePages;
    }

    public void setModifiedDatabasePages(Object modifiedDatabasePages) {
        this.modifiedDatabasePages = modifiedDatabasePages;
    }

    @Basic
    @Column(name = "PENDING_DECOMPRESS")
    public Object getPendingDecompress() {
        return pendingDecompress;
    }

    public void setPendingDecompress(Object pendingDecompress) {
        this.pendingDecompress = pendingDecompress;
    }

    @Basic
    @Column(name = "PENDING_READS")
    public Object getPendingReads() {
        return pendingReads;
    }

    public void setPendingReads(Object pendingReads) {
        this.pendingReads = pendingReads;
    }

    @Basic
    @Column(name = "PENDING_FLUSH_LRU")
    public Object getPendingFlushLru() {
        return pendingFlushLru;
    }

    public void setPendingFlushLru(Object pendingFlushLru) {
        this.pendingFlushLru = pendingFlushLru;
    }

    @Basic
    @Column(name = "PENDING_FLUSH_LIST")
    public Object getPendingFlushList() {
        return pendingFlushList;
    }

    public void setPendingFlushList(Object pendingFlushList) {
        this.pendingFlushList = pendingFlushList;
    }

    @Basic
    @Column(name = "PAGES_MADE_YOUNG")
    public Object getPagesMadeYoung() {
        return pagesMadeYoung;
    }

    public void setPagesMadeYoung(Object pagesMadeYoung) {
        this.pagesMadeYoung = pagesMadeYoung;
    }

    @Basic
    @Column(name = "PAGES_NOT_MADE_YOUNG")
    public Object getPagesNotMadeYoung() {
        return pagesNotMadeYoung;
    }

    public void setPagesNotMadeYoung(Object pagesNotMadeYoung) {
        this.pagesNotMadeYoung = pagesNotMadeYoung;
    }

    @Basic
    @Column(name = "PAGES_MADE_YOUNG_RATE")
    public double getPagesMadeYoungRate() {
        return pagesMadeYoungRate;
    }

    public void setPagesMadeYoungRate(double pagesMadeYoungRate) {
        this.pagesMadeYoungRate = pagesMadeYoungRate;
    }

    @Basic
    @Column(name = "PAGES_MADE_NOT_YOUNG_RATE")
    public double getPagesMadeNotYoungRate() {
        return pagesMadeNotYoungRate;
    }

    public void setPagesMadeNotYoungRate(double pagesMadeNotYoungRate) {
        this.pagesMadeNotYoungRate = pagesMadeNotYoungRate;
    }

    @Basic
    @Column(name = "NUMBER_PAGES_READ")
    public Object getNumberPagesRead() {
        return numberPagesRead;
    }

    public void setNumberPagesRead(Object numberPagesRead) {
        this.numberPagesRead = numberPagesRead;
    }

    @Basic
    @Column(name = "NUMBER_PAGES_CREATED")
    public Object getNumberPagesCreated() {
        return numberPagesCreated;
    }

    public void setNumberPagesCreated(Object numberPagesCreated) {
        this.numberPagesCreated = numberPagesCreated;
    }

    @Basic
    @Column(name = "NUMBER_PAGES_WRITTEN")
    public Object getNumberPagesWritten() {
        return numberPagesWritten;
    }

    public void setNumberPagesWritten(Object numberPagesWritten) {
        this.numberPagesWritten = numberPagesWritten;
    }

    @Basic
    @Column(name = "PAGES_READ_RATE")
    public double getPagesReadRate() {
        return pagesReadRate;
    }

    public void setPagesReadRate(double pagesReadRate) {
        this.pagesReadRate = pagesReadRate;
    }

    @Basic
    @Column(name = "PAGES_CREATE_RATE")
    public double getPagesCreateRate() {
        return pagesCreateRate;
    }

    public void setPagesCreateRate(double pagesCreateRate) {
        this.pagesCreateRate = pagesCreateRate;
    }

    @Basic
    @Column(name = "PAGES_WRITTEN_RATE")
    public double getPagesWrittenRate() {
        return pagesWrittenRate;
    }

    public void setPagesWrittenRate(double pagesWrittenRate) {
        this.pagesWrittenRate = pagesWrittenRate;
    }

    @Basic
    @Column(name = "NUMBER_PAGES_GET")
    public Object getNumberPagesGet() {
        return numberPagesGet;
    }

    public void setNumberPagesGet(Object numberPagesGet) {
        this.numberPagesGet = numberPagesGet;
    }

    @Basic
    @Column(name = "HIT_RATE")
    public Object getHitRate() {
        return hitRate;
    }

    public void setHitRate(Object hitRate) {
        this.hitRate = hitRate;
    }

    @Basic
    @Column(name = "YOUNG_MAKE_PER_THOUSAND_GETS")
    public Object getYoungMakePerThousandGets() {
        return youngMakePerThousandGets;
    }

    public void setYoungMakePerThousandGets(Object youngMakePerThousandGets) {
        this.youngMakePerThousandGets = youngMakePerThousandGets;
    }

    @Basic
    @Column(name = "NOT_YOUNG_MAKE_PER_THOUSAND_GETS")
    public Object getNotYoungMakePerThousandGets() {
        return notYoungMakePerThousandGets;
    }

    public void setNotYoungMakePerThousandGets(Object notYoungMakePerThousandGets) {
        this.notYoungMakePerThousandGets = notYoungMakePerThousandGets;
    }

    @Basic
    @Column(name = "NUMBER_PAGES_READ_AHEAD")
    public Object getNumberPagesReadAhead() {
        return numberPagesReadAhead;
    }

    public void setNumberPagesReadAhead(Object numberPagesReadAhead) {
        this.numberPagesReadAhead = numberPagesReadAhead;
    }

    @Basic
    @Column(name = "NUMBER_READ_AHEAD_EVICTED")
    public Object getNumberReadAheadEvicted() {
        return numberReadAheadEvicted;
    }

    public void setNumberReadAheadEvicted(Object numberReadAheadEvicted) {
        this.numberReadAheadEvicted = numberReadAheadEvicted;
    }

    @Basic
    @Column(name = "READ_AHEAD_RATE")
    public double getReadAheadRate() {
        return readAheadRate;
    }

    public void setReadAheadRate(double readAheadRate) {
        this.readAheadRate = readAheadRate;
    }

    @Basic
    @Column(name = "READ_AHEAD_EVICTED_RATE")
    public double getReadAheadEvictedRate() {
        return readAheadEvictedRate;
    }

    public void setReadAheadEvictedRate(double readAheadEvictedRate) {
        this.readAheadEvictedRate = readAheadEvictedRate;
    }

    @Basic
    @Column(name = "LRU_IO_TOTAL")
    public Object getLruIoTotal() {
        return lruIoTotal;
    }

    public void setLruIoTotal(Object lruIoTotal) {
        this.lruIoTotal = lruIoTotal;
    }

    @Basic
    @Column(name = "LRU_IO_CURRENT")
    public Object getLruIoCurrent() {
        return lruIoCurrent;
    }

    public void setLruIoCurrent(Object lruIoCurrent) {
        this.lruIoCurrent = lruIoCurrent;
    }

    @Basic
    @Column(name = "UNCOMPRESS_TOTAL")
    public Object getUncompressTotal() {
        return uncompressTotal;
    }

    public void setUncompressTotal(Object uncompressTotal) {
        this.uncompressTotal = uncompressTotal;
    }

    @Basic
    @Column(name = "UNCOMPRESS_CURRENT")
    public Object getUncompressCurrent() {
        return uncompressCurrent;
    }

    public void setUncompressCurrent(Object uncompressCurrent) {
        this.uncompressCurrent = uncompressCurrent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbBufferPoolStatsEntity that = (InnodbBufferPoolStatsEntity) o;
        return Double.compare(that.pagesMadeYoungRate, pagesMadeYoungRate) == 0 && Double.compare(that.pagesMadeNotYoungRate, pagesMadeNotYoungRate) == 0 && Double.compare(that.pagesReadRate, pagesReadRate) == 0 && Double.compare(that.pagesCreateRate, pagesCreateRate) == 0 && Double.compare(that.pagesWrittenRate, pagesWrittenRate) == 0 && Double.compare(that.readAheadRate, readAheadRate) == 0 && Double.compare(that.readAheadEvictedRate, readAheadEvictedRate) == 0 && Objects.equals(poolId, that.poolId) && Objects.equals(poolSize, that.poolSize) && Objects.equals(freeBuffers, that.freeBuffers) && Objects.equals(databasePages, that.databasePages) && Objects.equals(oldDatabasePages, that.oldDatabasePages) && Objects.equals(modifiedDatabasePages, that.modifiedDatabasePages) && Objects.equals(pendingDecompress, that.pendingDecompress) && Objects.equals(pendingReads, that.pendingReads) && Objects.equals(pendingFlushLru, that.pendingFlushLru) && Objects.equals(pendingFlushList, that.pendingFlushList) && Objects.equals(pagesMadeYoung, that.pagesMadeYoung) && Objects.equals(pagesNotMadeYoung, that.pagesNotMadeYoung) && Objects.equals(numberPagesRead, that.numberPagesRead) && Objects.equals(numberPagesCreated, that.numberPagesCreated) && Objects.equals(numberPagesWritten, that.numberPagesWritten) && Objects.equals(numberPagesGet, that.numberPagesGet) && Objects.equals(hitRate, that.hitRate) && Objects.equals(youngMakePerThousandGets, that.youngMakePerThousandGets) && Objects.equals(notYoungMakePerThousandGets, that.notYoungMakePerThousandGets) && Objects.equals(numberPagesReadAhead, that.numberPagesReadAhead) && Objects.equals(numberReadAheadEvicted, that.numberReadAheadEvicted) && Objects.equals(lruIoTotal, that.lruIoTotal) && Objects.equals(lruIoCurrent, that.lruIoCurrent) && Objects.equals(uncompressTotal, that.uncompressTotal) && Objects.equals(uncompressCurrent, that.uncompressCurrent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poolId, poolSize, freeBuffers, databasePages, oldDatabasePages, modifiedDatabasePages, pendingDecompress, pendingReads, pendingFlushLru, pendingFlushList, pagesMadeYoung, pagesNotMadeYoung, pagesMadeYoungRate, pagesMadeNotYoungRate, numberPagesRead, numberPagesCreated, numberPagesWritten, pagesReadRate, pagesCreateRate, pagesWrittenRate, numberPagesGet, hitRate, youngMakePerThousandGets, notYoungMakePerThousandGets, numberPagesReadAhead, numberReadAheadEvicted, readAheadRate, readAheadEvictedRate, lruIoTotal, lruIoCurrent, uncompressTotal, uncompressCurrent);
    }
}
