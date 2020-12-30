package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "INNODB_TRX", schema = "information_schema", catalog = "")
public class InnodbTrxEntity {
    private Object trxId;
    private String trxState;
    private Timestamp trxStarted;
    private String trxRequestedLockId;
    private Timestamp trxWaitStarted;
    private Object trxWeight;
    private Object trxMysqlThreadId;
    private String trxQuery;
    private String trxOperationState;
    private Object trxTablesInUse;
    private Object trxTablesLocked;
    private Object trxLockStructs;
    private Object trxLockMemoryBytes;
    private Object trxRowsLocked;
    private Object trxRowsModified;
    private Object trxConcurrencyTickets;
    private String trxIsolationLevel;
    private int trxUniqueChecks;
    private int trxForeignKeyChecks;
    private String trxLastForeignKeyError;
    private int trxAdaptiveHashLatched;
    private Object trxAdaptiveHashTimeout;
    private int trxIsReadOnly;
    private int trxAutocommitNonLocking;
    private Object trxScheduleWeight;

    @Basic
    @Column(name = "trx_id")
    public Object getTrxId() {
        return trxId;
    }

    public void setTrxId(Object trxId) {
        this.trxId = trxId;
    }

    @Basic
    @Column(name = "trx_state")
    public String getTrxState() {
        return trxState;
    }

    public void setTrxState(String trxState) {
        this.trxState = trxState;
    }

    @Basic
    @Column(name = "trx_started")
    public Timestamp getTrxStarted() {
        return trxStarted;
    }

    public void setTrxStarted(Timestamp trxStarted) {
        this.trxStarted = trxStarted;
    }

    @Basic
    @Column(name = "trx_requested_lock_id")
    public String getTrxRequestedLockId() {
        return trxRequestedLockId;
    }

    public void setTrxRequestedLockId(String trxRequestedLockId) {
        this.trxRequestedLockId = trxRequestedLockId;
    }

    @Basic
    @Column(name = "trx_wait_started")
    public Timestamp getTrxWaitStarted() {
        return trxWaitStarted;
    }

    public void setTrxWaitStarted(Timestamp trxWaitStarted) {
        this.trxWaitStarted = trxWaitStarted;
    }

    @Basic
    @Column(name = "trx_weight")
    public Object getTrxWeight() {
        return trxWeight;
    }

    public void setTrxWeight(Object trxWeight) {
        this.trxWeight = trxWeight;
    }

    @Basic
    @Column(name = "trx_mysql_thread_id")
    public Object getTrxMysqlThreadId() {
        return trxMysqlThreadId;
    }

    public void setTrxMysqlThreadId(Object trxMysqlThreadId) {
        this.trxMysqlThreadId = trxMysqlThreadId;
    }

    @Basic
    @Column(name = "trx_query")
    public String getTrxQuery() {
        return trxQuery;
    }

    public void setTrxQuery(String trxQuery) {
        this.trxQuery = trxQuery;
    }

    @Basic
    @Column(name = "trx_operation_state")
    public String getTrxOperationState() {
        return trxOperationState;
    }

    public void setTrxOperationState(String trxOperationState) {
        this.trxOperationState = trxOperationState;
    }

    @Basic
    @Column(name = "trx_tables_in_use")
    public Object getTrxTablesInUse() {
        return trxTablesInUse;
    }

    public void setTrxTablesInUse(Object trxTablesInUse) {
        this.trxTablesInUse = trxTablesInUse;
    }

    @Basic
    @Column(name = "trx_tables_locked")
    public Object getTrxTablesLocked() {
        return trxTablesLocked;
    }

    public void setTrxTablesLocked(Object trxTablesLocked) {
        this.trxTablesLocked = trxTablesLocked;
    }

    @Basic
    @Column(name = "trx_lock_structs")
    public Object getTrxLockStructs() {
        return trxLockStructs;
    }

    public void setTrxLockStructs(Object trxLockStructs) {
        this.trxLockStructs = trxLockStructs;
    }

    @Basic
    @Column(name = "trx_lock_memory_bytes")
    public Object getTrxLockMemoryBytes() {
        return trxLockMemoryBytes;
    }

    public void setTrxLockMemoryBytes(Object trxLockMemoryBytes) {
        this.trxLockMemoryBytes = trxLockMemoryBytes;
    }

    @Basic
    @Column(name = "trx_rows_locked")
    public Object getTrxRowsLocked() {
        return trxRowsLocked;
    }

    public void setTrxRowsLocked(Object trxRowsLocked) {
        this.trxRowsLocked = trxRowsLocked;
    }

    @Basic
    @Column(name = "trx_rows_modified")
    public Object getTrxRowsModified() {
        return trxRowsModified;
    }

    public void setTrxRowsModified(Object trxRowsModified) {
        this.trxRowsModified = trxRowsModified;
    }

    @Basic
    @Column(name = "trx_concurrency_tickets")
    public Object getTrxConcurrencyTickets() {
        return trxConcurrencyTickets;
    }

    public void setTrxConcurrencyTickets(Object trxConcurrencyTickets) {
        this.trxConcurrencyTickets = trxConcurrencyTickets;
    }

    @Basic
    @Column(name = "trx_isolation_level")
    public String getTrxIsolationLevel() {
        return trxIsolationLevel;
    }

    public void setTrxIsolationLevel(String trxIsolationLevel) {
        this.trxIsolationLevel = trxIsolationLevel;
    }

    @Basic
    @Column(name = "trx_unique_checks")
    public int getTrxUniqueChecks() {
        return trxUniqueChecks;
    }

    public void setTrxUniqueChecks(int trxUniqueChecks) {
        this.trxUniqueChecks = trxUniqueChecks;
    }

    @Basic
    @Column(name = "trx_foreign_key_checks")
    public int getTrxForeignKeyChecks() {
        return trxForeignKeyChecks;
    }

    public void setTrxForeignKeyChecks(int trxForeignKeyChecks) {
        this.trxForeignKeyChecks = trxForeignKeyChecks;
    }

    @Basic
    @Column(name = "trx_last_foreign_key_error")
    public String getTrxLastForeignKeyError() {
        return trxLastForeignKeyError;
    }

    public void setTrxLastForeignKeyError(String trxLastForeignKeyError) {
        this.trxLastForeignKeyError = trxLastForeignKeyError;
    }

    @Basic
    @Column(name = "trx_adaptive_hash_latched")
    public int getTrxAdaptiveHashLatched() {
        return trxAdaptiveHashLatched;
    }

    public void setTrxAdaptiveHashLatched(int trxAdaptiveHashLatched) {
        this.trxAdaptiveHashLatched = trxAdaptiveHashLatched;
    }

    @Basic
    @Column(name = "trx_adaptive_hash_timeout")
    public Object getTrxAdaptiveHashTimeout() {
        return trxAdaptiveHashTimeout;
    }

    public void setTrxAdaptiveHashTimeout(Object trxAdaptiveHashTimeout) {
        this.trxAdaptiveHashTimeout = trxAdaptiveHashTimeout;
    }

    @Basic
    @Column(name = "trx_is_read_only")
    public int getTrxIsReadOnly() {
        return trxIsReadOnly;
    }

    public void setTrxIsReadOnly(int trxIsReadOnly) {
        this.trxIsReadOnly = trxIsReadOnly;
    }

    @Basic
    @Column(name = "trx_autocommit_non_locking")
    public int getTrxAutocommitNonLocking() {
        return trxAutocommitNonLocking;
    }

    public void setTrxAutocommitNonLocking(int trxAutocommitNonLocking) {
        this.trxAutocommitNonLocking = trxAutocommitNonLocking;
    }

    @Basic
    @Column(name = "trx_schedule_weight")
    public Object getTrxScheduleWeight() {
        return trxScheduleWeight;
    }

    public void setTrxScheduleWeight(Object trxScheduleWeight) {
        this.trxScheduleWeight = trxScheduleWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbTrxEntity that = (InnodbTrxEntity) o;
        return trxUniqueChecks == that.trxUniqueChecks && trxForeignKeyChecks == that.trxForeignKeyChecks && trxAdaptiveHashLatched == that.trxAdaptiveHashLatched && trxIsReadOnly == that.trxIsReadOnly && trxAutocommitNonLocking == that.trxAutocommitNonLocking && Objects.equals(trxId, that.trxId) && Objects.equals(trxState, that.trxState) && Objects.equals(trxStarted, that.trxStarted) && Objects.equals(trxRequestedLockId, that.trxRequestedLockId) && Objects.equals(trxWaitStarted, that.trxWaitStarted) && Objects.equals(trxWeight, that.trxWeight) && Objects.equals(trxMysqlThreadId, that.trxMysqlThreadId) && Objects.equals(trxQuery, that.trxQuery) && Objects.equals(trxOperationState, that.trxOperationState) && Objects.equals(trxTablesInUse, that.trxTablesInUse) && Objects.equals(trxTablesLocked, that.trxTablesLocked) && Objects.equals(trxLockStructs, that.trxLockStructs) && Objects.equals(trxLockMemoryBytes, that.trxLockMemoryBytes) && Objects.equals(trxRowsLocked, that.trxRowsLocked) && Objects.equals(trxRowsModified, that.trxRowsModified) && Objects.equals(trxConcurrencyTickets, that.trxConcurrencyTickets) && Objects.equals(trxIsolationLevel, that.trxIsolationLevel) && Objects.equals(trxLastForeignKeyError, that.trxLastForeignKeyError) && Objects.equals(trxAdaptiveHashTimeout, that.trxAdaptiveHashTimeout) && Objects.equals(trxScheduleWeight, that.trxScheduleWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trxId, trxState, trxStarted, trxRequestedLockId, trxWaitStarted, trxWeight, trxMysqlThreadId, trxQuery, trxOperationState, trxTablesInUse, trxTablesLocked, trxLockStructs, trxLockMemoryBytes, trxRowsLocked, trxRowsModified, trxConcurrencyTickets, trxIsolationLevel, trxUniqueChecks, trxForeignKeyChecks, trxLastForeignKeyError, trxAdaptiveHashLatched, trxAdaptiveHashTimeout, trxIsReadOnly, trxAutocommitNonLocking, trxScheduleWeight);
    }
}
