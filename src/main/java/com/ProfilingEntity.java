package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "PROFILING", schema = "information_schema", catalog = "")
public class ProfilingEntity {
    private int queryId;
    private int seq;
    private String state;
    private BigInteger duration;
    private BigInteger cpuUser;
    private BigInteger cpuSystem;
    private Integer contextVoluntary;
    private Integer contextInvoluntary;
    private Integer blockOpsIn;
    private Integer blockOpsOut;
    private Integer messagesSent;
    private Integer messagesReceived;
    private Integer pageFaultsMajor;
    private Integer pageFaultsMinor;
    private Integer swaps;
    private String sourceFunction;
    private String sourceFile;
    private Integer sourceLine;

    @Basic
    @Column(name = "QUERY_ID")
    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    @Basic
    @Column(name = "SEQ")
    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "DURATION")
    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "CPU_USER")
    public BigInteger getCpuUser() {
        return cpuUser;
    }

    public void setCpuUser(BigInteger cpuUser) {
        this.cpuUser = cpuUser;
    }

    @Basic
    @Column(name = "CPU_SYSTEM")
    public BigInteger getCpuSystem() {
        return cpuSystem;
    }

    public void setCpuSystem(BigInteger cpuSystem) {
        this.cpuSystem = cpuSystem;
    }

    @Basic
    @Column(name = "CONTEXT_VOLUNTARY")
    public Integer getContextVoluntary() {
        return contextVoluntary;
    }

    public void setContextVoluntary(Integer contextVoluntary) {
        this.contextVoluntary = contextVoluntary;
    }

    @Basic
    @Column(name = "CONTEXT_INVOLUNTARY")
    public Integer getContextInvoluntary() {
        return contextInvoluntary;
    }

    public void setContextInvoluntary(Integer contextInvoluntary) {
        this.contextInvoluntary = contextInvoluntary;
    }

    @Basic
    @Column(name = "BLOCK_OPS_IN")
    public Integer getBlockOpsIn() {
        return blockOpsIn;
    }

    public void setBlockOpsIn(Integer blockOpsIn) {
        this.blockOpsIn = blockOpsIn;
    }

    @Basic
    @Column(name = "BLOCK_OPS_OUT")
    public Integer getBlockOpsOut() {
        return blockOpsOut;
    }

    public void setBlockOpsOut(Integer blockOpsOut) {
        this.blockOpsOut = blockOpsOut;
    }

    @Basic
    @Column(name = "MESSAGES_SENT")
    public Integer getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(Integer messagesSent) {
        this.messagesSent = messagesSent;
    }

    @Basic
    @Column(name = "MESSAGES_RECEIVED")
    public Integer getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(Integer messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    @Basic
    @Column(name = "PAGE_FAULTS_MAJOR")
    public Integer getPageFaultsMajor() {
        return pageFaultsMajor;
    }

    public void setPageFaultsMajor(Integer pageFaultsMajor) {
        this.pageFaultsMajor = pageFaultsMajor;
    }

    @Basic
    @Column(name = "PAGE_FAULTS_MINOR")
    public Integer getPageFaultsMinor() {
        return pageFaultsMinor;
    }

    public void setPageFaultsMinor(Integer pageFaultsMinor) {
        this.pageFaultsMinor = pageFaultsMinor;
    }

    @Basic
    @Column(name = "SWAPS")
    public Integer getSwaps() {
        return swaps;
    }

    public void setSwaps(Integer swaps) {
        this.swaps = swaps;
    }

    @Basic
    @Column(name = "SOURCE_FUNCTION")
    public String getSourceFunction() {
        return sourceFunction;
    }

    public void setSourceFunction(String sourceFunction) {
        this.sourceFunction = sourceFunction;
    }

    @Basic
    @Column(name = "SOURCE_FILE")
    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Basic
    @Column(name = "SOURCE_LINE")
    public Integer getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(Integer sourceLine) {
        this.sourceLine = sourceLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfilingEntity that = (ProfilingEntity) o;
        return queryId == that.queryId && seq == that.seq && Objects.equals(state, that.state) && Objects.equals(duration, that.duration) && Objects.equals(cpuUser, that.cpuUser) && Objects.equals(cpuSystem, that.cpuSystem) && Objects.equals(contextVoluntary, that.contextVoluntary) && Objects.equals(contextInvoluntary, that.contextInvoluntary) && Objects.equals(blockOpsIn, that.blockOpsIn) && Objects.equals(blockOpsOut, that.blockOpsOut) && Objects.equals(messagesSent, that.messagesSent) && Objects.equals(messagesReceived, that.messagesReceived) && Objects.equals(pageFaultsMajor, that.pageFaultsMajor) && Objects.equals(pageFaultsMinor, that.pageFaultsMinor) && Objects.equals(swaps, that.swaps) && Objects.equals(sourceFunction, that.sourceFunction) && Objects.equals(sourceFile, that.sourceFile) && Objects.equals(sourceLine, that.sourceLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryId, seq, state, duration, cpuUser, cpuSystem, contextVoluntary, contextInvoluntary, blockOpsIn, blockOpsOut, messagesSent, messagesReceived, pageFaultsMajor, pageFaultsMinor, swaps, sourceFunction, sourceFile, sourceLine);
    }
}
