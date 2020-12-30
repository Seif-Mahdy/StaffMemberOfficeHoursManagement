package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "COLUMNS", schema = "information_schema", catalog = "")
public class ColumnsEntity {
    private String tableCatalog;
    private String tableSchema;
    private String tableName;
    private String columnName;
    private Object ordinalPosition;
    private String columnDefault;
    private String isNullable;
    private String dataType;
    private Long characterMaximumLength;
    private Long characterOctetLength;
    private Object numericPrecision;
    private Object numericScale;
    private Object datetimePrecision;
    private String characterSetName;
    private String collationName;
    private String columnType;
    private Object columnKey;
    private String extra;
    private String privileges;
    private String columnComment;
    private String generationExpression;
    private Object srsId;

    @Basic
    @Column(name = "TABLE_CATALOG")
    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }

    @Basic
    @Column(name = "TABLE_SCHEMA")
    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    @Basic
    @Column(name = "TABLE_NAME")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "COLUMN_NAME")
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
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
    @Column(name = "COLUMN_DEFAULT")
    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    @Basic
    @Column(name = "IS_NULLABLE")
    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
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
    @Column(name = "COLUMN_TYPE")
    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    @Basic
    @Column(name = "COLUMN_KEY")
    public Object getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(Object columnKey) {
        this.columnKey = columnKey;
    }

    @Basic
    @Column(name = "EXTRA")
    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Basic
    @Column(name = "PRIVILEGES")
    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    @Basic
    @Column(name = "COLUMN_COMMENT")
    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    @Basic
    @Column(name = "GENERATION_EXPRESSION")
    public String getGenerationExpression() {
        return generationExpression;
    }

    public void setGenerationExpression(String generationExpression) {
        this.generationExpression = generationExpression;
    }

    @Basic
    @Column(name = "SRS_ID")
    public Object getSrsId() {
        return srsId;
    }

    public void setSrsId(Object srsId) {
        this.srsId = srsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnsEntity that = (ColumnsEntity) o;
        return Objects.equals(tableCatalog, that.tableCatalog) && Objects.equals(tableSchema, that.tableSchema) && Objects.equals(tableName, that.tableName) && Objects.equals(columnName, that.columnName) && Objects.equals(ordinalPosition, that.ordinalPosition) && Objects.equals(columnDefault, that.columnDefault) && Objects.equals(isNullable, that.isNullable) && Objects.equals(dataType, that.dataType) && Objects.equals(characterMaximumLength, that.characterMaximumLength) && Objects.equals(characterOctetLength, that.characterOctetLength) && Objects.equals(numericPrecision, that.numericPrecision) && Objects.equals(numericScale, that.numericScale) && Objects.equals(datetimePrecision, that.datetimePrecision) && Objects.equals(characterSetName, that.characterSetName) && Objects.equals(collationName, that.collationName) && Objects.equals(columnType, that.columnType) && Objects.equals(columnKey, that.columnKey) && Objects.equals(extra, that.extra) && Objects.equals(privileges, that.privileges) && Objects.equals(columnComment, that.columnComment) && Objects.equals(generationExpression, that.generationExpression) && Objects.equals(srsId, that.srsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableCatalog, tableSchema, tableName, columnName, ordinalPosition, columnDefault, isNullable, dataType, characterMaximumLength, characterOctetLength, numericPrecision, numericScale, datetimePrecision, characterSetName, collationName, columnType, columnKey, extra, privileges, columnComment, generationExpression, srsId);
    }
}
