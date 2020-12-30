package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "ROUTINES", schema = "information_schema", catalog = "")
public class RoutinesEntity {
    private String specificName;
    private String routineCatalog;
    private String routineSchema;
    private String routineName;
    private Object routineType;
    private String dataType;
    private Long characterMaximumLength;
    private Long characterOctetLength;
    private Object numericPrecision;
    private Object numericScale;
    private Object datetimePrecision;
    private String characterSetName;
    private String collationName;
    private String dtdIdentifier;
    private String routineBody;
    private String routineDefinition;
    private byte[] externalName;
    private String externalLanguage;
    private String parameterStyle;
    private String isDeterministic;
    private Object sqlDataAccess;
    private byte[] sqlPath;
    private Object securityType;
    private Timestamp created;
    private Timestamp lastAltered;
    private Object sqlMode;
    private String routineComment;
    private String definer;
    private String characterSetClient;
    private String collationConnection;
    private String databaseCollation;

    @Basic
    @Column(name = "SPECIFIC_NAME")
    public String getSpecificName() {
        return specificName;
    }

    public void setSpecificName(String specificName) {
        this.specificName = specificName;
    }

    @Basic
    @Column(name = "ROUTINE_CATALOG")
    public String getRoutineCatalog() {
        return routineCatalog;
    }

    public void setRoutineCatalog(String routineCatalog) {
        this.routineCatalog = routineCatalog;
    }

    @Basic
    @Column(name = "ROUTINE_SCHEMA")
    public String getRoutineSchema() {
        return routineSchema;
    }

    public void setRoutineSchema(String routineSchema) {
        this.routineSchema = routineSchema;
    }

    @Basic
    @Column(name = "ROUTINE_NAME")
    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    @Basic
    @Column(name = "ROUTINE_TYPE")
    public Object getRoutineType() {
        return routineType;
    }

    public void setRoutineType(Object routineType) {
        this.routineType = routineType;
    }

    @Basic
    @Column(name = "DATA_TYPE")
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Basic
    @Column(name = "CHARACTER_MAXIMUM_LENGTH")
    public Long getCharacterMaximumLength() {
        return characterMaximumLength;
    }

    public void setCharacterMaximumLength(Long characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    @Basic
    @Column(name = "CHARACTER_OCTET_LENGTH")
    public Long getCharacterOctetLength() {
        return characterOctetLength;
    }

    public void setCharacterOctetLength(Long characterOctetLength) {
        this.characterOctetLength = characterOctetLength;
    }

    @Basic
    @Column(name = "NUMERIC_PRECISION")
    public Object getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(Object numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    @Basic
    @Column(name = "NUMERIC_SCALE")
    public Object getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(Object numericScale) {
        this.numericScale = numericScale;
    }

    @Basic
    @Column(name = "DATETIME_PRECISION")
    public Object getDatetimePrecision() {
        return datetimePrecision;
    }

    public void setDatetimePrecision(Object datetimePrecision) {
        this.datetimePrecision = datetimePrecision;
    }

    @Basic
    @Column(name = "CHARACTER_SET_NAME")
    public String getCharacterSetName() {
        return characterSetName;
    }

    public void setCharacterSetName(String characterSetName) {
        this.characterSetName = characterSetName;
    }

    @Basic
    @Column(name = "COLLATION_NAME")
    public String getCollationName() {
        return collationName;
    }

    public void setCollationName(String collationName) {
        this.collationName = collationName;
    }

    @Basic
    @Column(name = "DTD_IDENTIFIER")
    public String getDtdIdentifier() {
        return dtdIdentifier;
    }

    public void setDtdIdentifier(String dtdIdentifier) {
        this.dtdIdentifier = dtdIdentifier;
    }

    @Basic
    @Column(name = "ROUTINE_BODY")
    public String getRoutineBody() {
        return routineBody;
    }

    public void setRoutineBody(String routineBody) {
        this.routineBody = routineBody;
    }

    @Basic
    @Column(name = "ROUTINE_DEFINITION")
    public String getRoutineDefinition() {
        return routineDefinition;
    }

    public void setRoutineDefinition(String routineDefinition) {
        this.routineDefinition = routineDefinition;
    }

    @Basic
    @Column(name = "EXTERNAL_NAME")
    public byte[] getExternalName() {
        return externalName;
    }

    public void setExternalName(byte[] externalName) {
        this.externalName = externalName;
    }

    @Basic
    @Column(name = "EXTERNAL_LANGUAGE")
    public String getExternalLanguage() {
        return externalLanguage;
    }

    public void setExternalLanguage(String externalLanguage) {
        this.externalLanguage = externalLanguage;
    }

    @Basic
    @Column(name = "PARAMETER_STYLE")
    public String getParameterStyle() {
        return parameterStyle;
    }

    public void setParameterStyle(String parameterStyle) {
        this.parameterStyle = parameterStyle;
    }

    @Basic
    @Column(name = "IS_DETERMINISTIC")
    public String getIsDeterministic() {
        return isDeterministic;
    }

    public void setIsDeterministic(String isDeterministic) {
        this.isDeterministic = isDeterministic;
    }

    @Basic
    @Column(name = "SQL_DATA_ACCESS")
    public Object getSqlDataAccess() {
        return sqlDataAccess;
    }

    public void setSqlDataAccess(Object sqlDataAccess) {
        this.sqlDataAccess = sqlDataAccess;
    }

    @Basic
    @Column(name = "SQL_PATH")
    public byte[] getSqlPath() {
        return sqlPath;
    }

    public void setSqlPath(byte[] sqlPath) {
        this.sqlPath = sqlPath;
    }

    @Basic
    @Column(name = "SECURITY_TYPE")
    public Object getSecurityType() {
        return securityType;
    }

    public void setSecurityType(Object securityType) {
        this.securityType = securityType;
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
    @Column(name = "SQL_MODE")
    public Object getSqlMode() {
        return sqlMode;
    }

    public void setSqlMode(Object sqlMode) {
        this.sqlMode = sqlMode;
    }

    @Basic
    @Column(name = "ROUTINE_COMMENT")
    public String getRoutineComment() {
        return routineComment;
    }

    public void setRoutineComment(String routineComment) {
        this.routineComment = routineComment;
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
        RoutinesEntity that = (RoutinesEntity) o;
        return Objects.equals(specificName, that.specificName) && Objects.equals(routineCatalog, that.routineCatalog) && Objects.equals(routineSchema, that.routineSchema) && Objects.equals(routineName, that.routineName) && Objects.equals(routineType, that.routineType) && Objects.equals(dataType, that.dataType) && Objects.equals(characterMaximumLength, that.characterMaximumLength) && Objects.equals(characterOctetLength, that.characterOctetLength) && Objects.equals(numericPrecision, that.numericPrecision) && Objects.equals(numericScale, that.numericScale) && Objects.equals(datetimePrecision, that.datetimePrecision) && Objects.equals(characterSetName, that.characterSetName) && Objects.equals(collationName, that.collationName) && Objects.equals(dtdIdentifier, that.dtdIdentifier) && Objects.equals(routineBody, that.routineBody) && Objects.equals(routineDefinition, that.routineDefinition) && Arrays.equals(externalName, that.externalName) && Objects.equals(externalLanguage, that.externalLanguage) && Objects.equals(parameterStyle, that.parameterStyle) && Objects.equals(isDeterministic, that.isDeterministic) && Objects.equals(sqlDataAccess, that.sqlDataAccess) && Arrays.equals(sqlPath, that.sqlPath) && Objects.equals(securityType, that.securityType) && Objects.equals(created, that.created) && Objects.equals(lastAltered, that.lastAltered) && Objects.equals(sqlMode, that.sqlMode) && Objects.equals(routineComment, that.routineComment) && Objects.equals(definer, that.definer) && Objects.equals(characterSetClient, that.characterSetClient) && Objects.equals(collationConnection, that.collationConnection) && Objects.equals(databaseCollation, that.databaseCollation);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(specificName, routineCatalog, routineSchema, routineName, routineType, dataType, characterMaximumLength, characterOctetLength, numericPrecision, numericScale, datetimePrecision, characterSetName, collationName, dtdIdentifier, routineBody, routineDefinition, externalLanguage, parameterStyle, isDeterministic, sqlDataAccess, securityType, created, lastAltered, sqlMode, routineComment, definer, characterSetClient, collationConnection, databaseCollation);
        result = 31 * result + Arrays.hashCode(externalName);
        result = 31 * result + Arrays.hashCode(sqlPath);
        return result;
    }
}
