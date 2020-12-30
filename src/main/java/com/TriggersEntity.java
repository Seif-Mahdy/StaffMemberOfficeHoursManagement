package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "TRIGGERS", schema = "information_schema", catalog = "")
public class TriggersEntity {
    private String triggerCatalog;
    private String triggerSchema;
    private String triggerName;
    private Object eventManipulation;
    private String eventObjectCatalog;
    private String eventObjectSchema;
    private String eventObjectTable;
    private Object actionOrder;
    private byte[] actionCondition;
    private String actionStatement;
    private String actionOrientation;
    private Object actionTiming;
    private byte[] actionReferenceOldTable;
    private byte[] actionReferenceNewTable;
    private String actionReferenceOldRow;
    private String actionReferenceNewRow;
    private Timestamp created;
    private Object sqlMode;
    private String definer;
    private String characterSetClient;
    private String collationConnection;
    private String databaseCollation;

    @Basic
    @Column(name = "TRIGGER_CATALOG")
    public String getTriggerCatalog() {
        return triggerCatalog;
    }

    public void setTriggerCatalog(String triggerCatalog) {
        this.triggerCatalog = triggerCatalog;
    }

    @Basic
    @Column(name = "TRIGGER_SCHEMA")
    public String getTriggerSchema() {
        return triggerSchema;
    }

    public void setTriggerSchema(String triggerSchema) {
        this.triggerSchema = triggerSchema;
    }

    @Basic
    @Column(name = "TRIGGER_NAME")
    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    @Basic
    @Column(name = "EVENT_MANIPULATION")
    public Object getEventManipulation() {
        return eventManipulation;
    }

    public void setEventManipulation(Object eventManipulation) {
        this.eventManipulation = eventManipulation;
    }

    @Basic
    @Column(name = "EVENT_OBJECT_CATALOG")
    public String getEventObjectCatalog() {
        return eventObjectCatalog;
    }

    public void setEventObjectCatalog(String eventObjectCatalog) {
        this.eventObjectCatalog = eventObjectCatalog;
    }

    @Basic
    @Column(name = "EVENT_OBJECT_SCHEMA")
    public String getEventObjectSchema() {
        return eventObjectSchema;
    }

    public void setEventObjectSchema(String eventObjectSchema) {
        this.eventObjectSchema = eventObjectSchema;
    }

    @Basic
    @Column(name = "EVENT_OBJECT_TABLE")
    public String getEventObjectTable() {
        return eventObjectTable;
    }

    public void setEventObjectTable(String eventObjectTable) {
        this.eventObjectTable = eventObjectTable;
    }

    @Basic
    @Column(name = "ACTION_ORDER")
    public Object getActionOrder() {
        return actionOrder;
    }

    public void setActionOrder(Object actionOrder) {
        this.actionOrder = actionOrder;
    }

    @Basic
    @Column(name = "ACTION_CONDITION")
    public byte[] getActionCondition() {
        return actionCondition;
    }

    public void setActionCondition(byte[] actionCondition) {
        this.actionCondition = actionCondition;
    }

    @Basic
    @Column(name = "ACTION_STATEMENT")
    public String getActionStatement() {
        return actionStatement;
    }

    public void setActionStatement(String actionStatement) {
        this.actionStatement = actionStatement;
    }

    @Basic
    @Column(name = "ACTION_ORIENTATION")
    public String getActionOrientation() {
        return actionOrientation;
    }

    public void setActionOrientation(String actionOrientation) {
        this.actionOrientation = actionOrientation;
    }

    @Basic
    @Column(name = "ACTION_TIMING")
    public Object getActionTiming() {
        return actionTiming;
    }

    public void setActionTiming(Object actionTiming) {
        this.actionTiming = actionTiming;
    }

    @Basic
    @Column(name = "ACTION_REFERENCE_OLD_TABLE")
    public byte[] getActionReferenceOldTable() {
        return actionReferenceOldTable;
    }

    public void setActionReferenceOldTable(byte[] actionReferenceOldTable) {
        this.actionReferenceOldTable = actionReferenceOldTable;
    }

    @Basic
    @Column(name = "ACTION_REFERENCE_NEW_TABLE")
    public byte[] getActionReferenceNewTable() {
        return actionReferenceNewTable;
    }

    public void setActionReferenceNewTable(byte[] actionReferenceNewTable) {
        this.actionReferenceNewTable = actionReferenceNewTable;
    }

    @Basic
    @Column(name = "ACTION_REFERENCE_OLD_ROW")
    public String getActionReferenceOldRow() {
        return actionReferenceOldRow;
    }

    public void setActionReferenceOldRow(String actionReferenceOldRow) {
        this.actionReferenceOldRow = actionReferenceOldRow;
    }

    @Basic
    @Column(name = "ACTION_REFERENCE_NEW_ROW")
    public String getActionReferenceNewRow() {
        return actionReferenceNewRow;
    }

    public void setActionReferenceNewRow(String actionReferenceNewRow) {
        this.actionReferenceNewRow = actionReferenceNewRow;
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
    @Column(name = "SQL_MODE")
    public Object getSqlMode() {
        return sqlMode;
    }

    public void setSqlMode(Object sqlMode) {
        this.sqlMode = sqlMode;
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
        TriggersEntity that = (TriggersEntity) o;
        return Objects.equals(triggerCatalog, that.triggerCatalog) && Objects.equals(triggerSchema, that.triggerSchema) && Objects.equals(triggerName, that.triggerName) && Objects.equals(eventManipulation, that.eventManipulation) && Objects.equals(eventObjectCatalog, that.eventObjectCatalog) && Objects.equals(eventObjectSchema, that.eventObjectSchema) && Objects.equals(eventObjectTable, that.eventObjectTable) && Objects.equals(actionOrder, that.actionOrder) && Arrays.equals(actionCondition, that.actionCondition) && Objects.equals(actionStatement, that.actionStatement) && Objects.equals(actionOrientation, that.actionOrientation) && Objects.equals(actionTiming, that.actionTiming) && Arrays.equals(actionReferenceOldTable, that.actionReferenceOldTable) && Arrays.equals(actionReferenceNewTable, that.actionReferenceNewTable) && Objects.equals(actionReferenceOldRow, that.actionReferenceOldRow) && Objects.equals(actionReferenceNewRow, that.actionReferenceNewRow) && Objects.equals(created, that.created) && Objects.equals(sqlMode, that.sqlMode) && Objects.equals(definer, that.definer) && Objects.equals(characterSetClient, that.characterSetClient) && Objects.equals(collationConnection, that.collationConnection) && Objects.equals(databaseCollation, that.databaseCollation);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(triggerCatalog, triggerSchema, triggerName, eventManipulation, eventObjectCatalog, eventObjectSchema, eventObjectTable, actionOrder, actionStatement, actionOrientation, actionTiming, actionReferenceOldRow, actionReferenceNewRow, created, sqlMode, definer, characterSetClient, collationConnection, databaseCollation);
        result = 31 * result + Arrays.hashCode(actionCondition);
        result = 31 * result + Arrays.hashCode(actionReferenceOldTable);
        result = 31 * result + Arrays.hashCode(actionReferenceNewTable);
        return result;
    }
}
