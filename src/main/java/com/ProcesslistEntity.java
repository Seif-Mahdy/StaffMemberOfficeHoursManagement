package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "PROCESSLIST", schema = "information_schema", catalog = "")
public class ProcesslistEntity {
    private Object id;
    private String user;
    private String host;
    private String db;
    private String command;
    private int time;
    private String state;
    private String info;

    @Basic
    @Column(name = "ID")
    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "HOST")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Basic
    @Column(name = "DB")
    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    @Basic
    @Column(name = "COMMAND")
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Basic
    @Column(name = "TIME")
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
    @Column(name = "INFO")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcesslistEntity that = (ProcesslistEntity) o;
        return time == that.time && Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(host, that.host) && Objects.equals(db, that.db) && Objects.equals(command, that.command) && Objects.equals(state, that.state) && Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, host, db, command, time, state, info);
    }
}
