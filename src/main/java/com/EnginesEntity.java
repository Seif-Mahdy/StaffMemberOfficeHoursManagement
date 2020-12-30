package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ENGINES", schema = "information_schema", catalog = "")
public class EnginesEntity {
    private String engine;
    private String support;
    private String comment;
    private String transactions;
    private String xa;
    private String savepoints;

    @Basic
    @Column(name = "ENGINE")
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Basic
    @Column(name = "SUPPORT")
    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    @Basic
    @Column(name = "COMMENT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "TRANSACTIONS")
    public String getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions = transactions;
    }

    @Basic
    @Column(name = "XA")
    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }

    @Basic
    @Column(name = "SAVEPOINTS")
    public String getSavepoints() {
        return savepoints;
    }

    public void setSavepoints(String savepoints) {
        this.savepoints = savepoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnginesEntity that = (EnginesEntity) o;
        return Objects.equals(engine, that.engine) && Objects.equals(support, that.support) && Objects.equals(comment, that.comment) && Objects.equals(transactions, that.transactions) && Objects.equals(xa, that.xa) && Objects.equals(savepoints, that.savepoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine, support, comment, transactions, xa, savepoints);
    }
}
