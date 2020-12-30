package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "OPTIMIZER_TRACE", schema = "information_schema", catalog = "")
public class OptimizerTraceEntity {
    private String query;
    private String trace;
    private int missingBytesBeyondMaxMemSize;
    private byte insufficientPrivileges;

    @Basic
    @Column(name = "QUERY")
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Basic
    @Column(name = "TRACE")
    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    @Basic
    @Column(name = "MISSING_BYTES_BEYOND_MAX_MEM_SIZE")
    public int getMissingBytesBeyondMaxMemSize() {
        return missingBytesBeyondMaxMemSize;
    }

    public void setMissingBytesBeyondMaxMemSize(int missingBytesBeyondMaxMemSize) {
        this.missingBytesBeyondMaxMemSize = missingBytesBeyondMaxMemSize;
    }

    @Basic
    @Column(name = "INSUFFICIENT_PRIVILEGES")
    public byte getInsufficientPrivileges() {
        return insufficientPrivileges;
    }

    public void setInsufficientPrivileges(byte insufficientPrivileges) {
        this.insufficientPrivileges = insufficientPrivileges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptimizerTraceEntity that = (OptimizerTraceEntity) o;
        return missingBytesBeyondMaxMemSize == that.missingBytesBeyondMaxMemSize && insufficientPrivileges == that.insufficientPrivileges && Objects.equals(query, that.query) && Objects.equals(trace, that.trace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(query, trace, missingBytesBeyondMaxMemSize, insufficientPrivileges);
    }
}
