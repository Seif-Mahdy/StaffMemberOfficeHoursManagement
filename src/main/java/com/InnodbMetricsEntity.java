package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "INNODB_METRICS", schema = "information_schema", catalog = "")
public class InnodbMetricsEntity {
    private String name;
    private String subsystem;
    private long count;
    private Long maxCount;
    private Long minCount;
    private Double avgCount;
    private long countReset;
    private Long maxCountReset;
    private Long minCountReset;
    private Double avgCountReset;
    private Timestamp timeEnabled;
    private Timestamp timeDisabled;
    private Long timeElapsed;
    private Timestamp timeReset;
    private String status;
    private String type;
    private String comment;

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SUBSYSTEM")
    public String getSubsystem() {
        return subsystem;
    }

    public void setSubsystem(String subsystem) {
        this.subsystem = subsystem;
    }

    @Basic
    @Column(name = "COUNT")
    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Basic
    @Column(name = "MAX_COUNT")
    public Long getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Long maxCount) {
        this.maxCount = maxCount;
    }

    @Basic
    @Column(name = "MIN_COUNT")
    public Long getMinCount() {
        return minCount;
    }

    public void setMinCount(Long minCount) {
        this.minCount = minCount;
    }

    @Basic
    @Column(name = "AVG_COUNT")
    public Double getAvgCount() {
        return avgCount;
    }

    public void setAvgCount(Double avgCount) {
        this.avgCount = avgCount;
    }

    @Basic
    @Column(name = "COUNT_RESET")
    public long getCountReset() {
        return countReset;
    }

    public void setCountReset(long countReset) {
        this.countReset = countReset;
    }

    @Basic
    @Column(name = "MAX_COUNT_RESET")
    public Long getMaxCountReset() {
        return maxCountReset;
    }

    public void setMaxCountReset(Long maxCountReset) {
        this.maxCountReset = maxCountReset;
    }

    @Basic
    @Column(name = "MIN_COUNT_RESET")
    public Long getMinCountReset() {
        return minCountReset;
    }

    public void setMinCountReset(Long minCountReset) {
        this.minCountReset = minCountReset;
    }

    @Basic
    @Column(name = "AVG_COUNT_RESET")
    public Double getAvgCountReset() {
        return avgCountReset;
    }

    public void setAvgCountReset(Double avgCountReset) {
        this.avgCountReset = avgCountReset;
    }

    @Basic
    @Column(name = "TIME_ENABLED")
    public Timestamp getTimeEnabled() {
        return timeEnabled;
    }

    public void setTimeEnabled(Timestamp timeEnabled) {
        this.timeEnabled = timeEnabled;
    }

    @Basic
    @Column(name = "TIME_DISABLED")
    public Timestamp getTimeDisabled() {
        return timeDisabled;
    }

    public void setTimeDisabled(Timestamp timeDisabled) {
        this.timeDisabled = timeDisabled;
    }

    @Basic
    @Column(name = "TIME_ELAPSED")
    public Long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    @Basic
    @Column(name = "TIME_RESET")
    public Timestamp getTimeReset() {
        return timeReset;
    }

    public void setTimeReset(Timestamp timeReset) {
        this.timeReset = timeReset;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "COMMENT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbMetricsEntity that = (InnodbMetricsEntity) o;
        return count == that.count && countReset == that.countReset && Objects.equals(name, that.name) && Objects.equals(subsystem, that.subsystem) && Objects.equals(maxCount, that.maxCount) && Objects.equals(minCount, that.minCount) && Objects.equals(avgCount, that.avgCount) && Objects.equals(maxCountReset, that.maxCountReset) && Objects.equals(minCountReset, that.minCountReset) && Objects.equals(avgCountReset, that.avgCountReset) && Objects.equals(timeEnabled, that.timeEnabled) && Objects.equals(timeDisabled, that.timeDisabled) && Objects.equals(timeElapsed, that.timeElapsed) && Objects.equals(timeReset, that.timeReset) && Objects.equals(status, that.status) && Objects.equals(type, that.type) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subsystem, count, maxCount, minCount, avgCount, countReset, maxCountReset, minCountReset, avgCountReset, timeEnabled, timeDisabled, timeElapsed, timeReset, status, type, comment);
    }
}
