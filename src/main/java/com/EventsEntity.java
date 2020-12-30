package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "EVENTS", schema = "information_schema", catalog = "")
public class EventsEntity {
    private String eventCatalog;
    private String eventSchema;
    private String eventName;
    private String definer;
    private String timeZone;
    private String eventBody;
    private String eventDefinition;
    private String eventType;
    private Timestamp executeAt;
    private String intervalValue;
    private Object intervalField;
    private Object sqlMode;
    private Timestamp starts;
    private Timestamp ends;
    private Object status;
    private String onCompletion;
    private Timestamp created;
    private Timestamp lastAltered;
    private Timestamp lastExecuted;
    private String eventComment;
    private Object originator;
    private String characterSetClient;
    private String collationConnection;
    private String databaseCollation;

    @Basic
    @Column(name = "EVENT_CATALOG")
    public String getEventCatalog() {
        return eventCatalog;
    }

    public void setEventCatalog(String eventCatalog) {
        this.eventCatalog = eventCatalog;
    }

    @Basic
    @Column(name = "EVENT_SCHEMA")
    public String getEventSchema() {
        return eventSchema;
    }

    public void setEventSchema(String eventSchema) {
        this.eventSchema = eventSchema;
    }

    @Basic
    @Column(name = "EVENT_NAME")
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Basic
    @Column(name = "DEFINER")
    public String getDefiner() {
        return definer;
    }

    public void setDefiner(String definer) {
        this.definer = definer;
    }

    @Basic
    @Column(name = "TIME_ZONE")
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Basic
    @Column(name = "EVENT_BODY")
    public String getEventBody() {
        return eventBody;
    }

    public void setEventBody(String eventBody) {
        this.eventBody = eventBody;
    }

    @Basic
    @Column(name = "EVENT_DEFINITION")
    public String getEventDefinition() {
        return eventDefinition;
    }

    public void setEventDefinition(String eventDefinition) {
        this.eventDefinition = eventDefinition;
    }

    @Basic
    @Column(name = "EVENT_TYPE")
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Basic
    @Column(name = "EXECUTE_AT")
    public Timestamp getExecuteAt() {
        return executeAt;
    }

    public void setExecuteAt(Timestamp executeAt) {
        this.executeAt = executeAt;
    }

    @Basic
    @Column(name = "INTERVAL_VALUE")
    public String getIntervalValue() {
        return intervalValue;
    }

    public void setIntervalValue(String intervalValue) {
        this.intervalValue = intervalValue;
    }

    @Basic
    @Column(name = "INTERVAL_FIELD")
    public Object getIntervalField() {
        return intervalField;
    }

    public void setIntervalField(Object intervalField) {
        this.intervalField = intervalField;
    }

    @Basic
    @Column(name = "SQL_MODE")
    public Object getSqlMode() {
        return sqlMode;
    }

    public void setSqlMode(Object sqlMode) {
        this.sqlMode = sqlMode;
    }

    @Basic
    @Column(name = "STARTS")
    public Timestamp getStarts() {
        return starts;
    }

    public void setStarts(Timestamp starts) {
        this.starts = starts;
    }

    @Basic
    @Column(name = "ENDS")
    public Timestamp getEnds() {
        return ends;
    }

    public void setEnds(Timestamp ends) {
        this.ends = ends;
    }

    @Basic
    @Column(name = "STATUS")
    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ON_COMPLETION")
    public String getOnCompletion() {
        return onCompletion;
    }

    public void setOnCompletion(String onCompletion) {
        this.onCompletion = onCompletion;
    }

    @Basic
    @Column(name = "CREATED")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "LAST_ALTERED")
    public Timestamp getLastAltered() {
        return lastAltered;
    }

    public void setLastAltered(Timestamp lastAltered) {
        this.lastAltered = lastAltered;
    }

    @Basic
    @Column(name = "LAST_EXECUTED")
    public Timestamp getLastExecuted() {
        return lastExecuted;
    }

    public void setLastExecuted(Timestamp lastExecuted) {
        this.lastExecuted = lastExecuted;
    }

    @Basic
    @Column(name = "EVENT_COMMENT")
    public String getEventComment() {
        return eventComment;
    }

    public void setEventComment(String eventComment) {
        this.eventComment = eventComment;
    }

    @Basic
    @Column(name = "ORIGINATOR")
    public Object getOriginator() {
        return originator;
    }

    public void setOriginator(Object originator) {
        this.originator = originator;
    }

    @Basic
    @Column(name = "CHARACTER_SET_CLIENT")
    public String getCharacterSetClient() {
        return characterSetClient;
    }

    public void setCharacterSetClient(String characterSetClient) {
        this.characterSetClient = characterSetClient;
    }

    @Basic
    @Column(name = "COLLATION_CONNECTION")
    public String getCollationConnection() {
        return collationConnection;
    }

    public void setCollationConnection(String collationConnection) {
        this.collationConnection = collationConnection;
    }

    @Basic
    @Column(name = "DATABASE_COLLATION")
    public String getDatabaseCollation() {
        return databaseCollation;
    }

    public void setDatabaseCollation(String databaseCollation) {
        this.databaseCollation = databaseCollation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventsEntity that = (EventsEntity) o;
        return Objects.equals(eventCatalog, that.eventCatalog) && Objects.equals(eventSchema, that.eventSchema) && Objects.equals(eventName, that.eventName) && Objects.equals(definer, that.definer) && Objects.equals(timeZone, that.timeZone) && Objects.equals(eventBody, that.eventBody) && Objects.equals(eventDefinition, that.eventDefinition) && Objects.equals(eventType, that.eventType) && Objects.equals(executeAt, that.executeAt) && Objects.equals(intervalValue, that.intervalValue) && Objects.equals(intervalField, that.intervalField) && Objects.equals(sqlMode, that.sqlMode) && Objects.equals(starts, that.starts) && Objects.equals(ends, that.ends) && Objects.equals(status, that.status) && Objects.equals(onCompletion, that.onCompletion) && Objects.equals(created, that.created) && Objects.equals(lastAltered, that.lastAltered) && Objects.equals(lastExecuted, that.lastExecuted) && Objects.equals(eventComment, that.eventComment) && Objects.equals(originator, that.originator) && Objects.equals(characterSetClient, that.characterSetClient) && Objects.equals(collationConnection, that.collationConnection) && Objects.equals(databaseCollation, that.databaseCollation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventCatalog, eventSchema, eventName, definer, timeZone, eventBody, eventDefinition, eventType, executeAt, intervalValue, intervalField, sqlMode, starts, ends, status, onCompletion, created, lastAltered, lastExecuted, eventComment, originator, characterSetClient, collationConnection, databaseCollation);
    }
}
