package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "PARAMETERS", schema = "information_schema", catalog = "")
public class ParametersEntity {
    private String specificCatalog;
    private String specificSchema;
    private String specificName;
    private Object ordinalPosition;
    private String parameterMode;
    private String parameterName;
    private String dataType;
    private Long characterMaximumLength;
    private Long characterOctetLength;
    private Object numericPrecision;
    private Long numericScale;
    private Object datetimePrecision;
    private String characterSetName;
    private String collationName;
    private String dtdIdentifier;
    private Object routineType;

    @Basic
    @Column(name = "SPECIFIC_CATALOG")
    public String getSpecificCatalog() {
        return specificCatalog;
    }

    public void setSpecificCatalog(String specificCatalog) {
        this.specificCatalog = specificCatalog;
    }

    @Basic
    @Column(name = "SPECIFIC_SCHEMA")
    public String getSpecificSchema() {
        return specificSchema;
    }

    public void setSpecificSchema(String specificSchema) {
        this.specificSchema = specificSchema;
    }

    @Basic
    @Column(name = "SPECIFIC_NAME")
    public String getSpecificName() {
        return specificName;
    }

    public void setSpecificName(String specificName) {
        this.specificName = specificName;
    }

    @Basic
    @Column(name = "ORDINAL_POSITION")
    public Object getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Object ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    @Basic
    @Column(name = "PARAMETER_MODE")
    public String getParameterMode() {
        return parameterMode;
    }

    public void setParameterMode(String parameterMode) {
        this.parameterMode = parameterMode;
    }

    @Basic
    @Column(name = "PARAMETER_NAME")
    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
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
    public Long getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(Long numericScale) {
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
    @Column(name = "ROUTINE_TYPE")
    public Object getRoutineType() {
        return routineType;
    }

    public void setRoutineType(Object routineType) {
        this.routineType = routineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParametersEntity that = (ParametersEntity) o;
        return Objects.equals(specificCatalog, that.specificCatalog) && Objects.equals(specificSchema, that.specificSchema) && Objects.equals(specificName, that.specificName) && Objects.equals(ordinalPosition, that.ordinalPosition) && Objects.equals(parameterMode, that.parameterMode) && Objects.equals(parameterName, that.parameterName) && Objects.equals(dataType, that.dataType) && Objects.equals(characterMaximumLength, that.characterMaximumLength) && Objects.equals(characterOctetLength, that.characterOctetLength) && Objects.equals(numericPrecision, that.numericPrecision) && Objects.equals(numericScale, that.numericScale) && Objects.equals(datetimePrecision, that.datetimePrecision) && Objects.equals(characterSetName, that.characterSetName) && Objects.equals(collationName, that.collationName) && Objects.equals(dtdIdentifier, that.dtdIdentifier) && Objects.equals(routineType, that.routineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specificCatalog, specificSchema, specificName, ordinalPosition, parameterMode, parameterName, dataType, characterMaximumLength, characterOctetLength, numericPrecision, numericScale, datetimePrecision, characterSetName, collationName, dtdIdentifier, routineType);
    }
}
