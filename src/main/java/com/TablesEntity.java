package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TABLES", schema = "information_schema", catalog = "")
public class TablesEntity {
    private String tableCatalog;
    private String tableSchema;
    private String tableName;
    private Object tableType;
    private String engine;
    private Integer version;
    private Object rowFormat;
    private Object tableRows;
    private Object avgRowLength;
    private Object dataLength;
    private Object maxDataLength;
    private Object indexLength;
    private Object dataFree;
    private Object autoIncrement;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp checkTime;
    private String tableCollation;
    private Long checksum;
    private String createOptions;
    private String tableComment;

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
    @Column(name = "TABLE_TYPE")
    public Object getTableType() {
        return tableType;
    }

    public void setTableType(Object tableType) {
        this.tableType = tableType;
    }

    @Basic
    @Column(name = "ENGINE")
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Basic
    @Column(name = "VERSION")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "ROW_FORMAT")
    public Object getRowFormat() {
        return rowFormat;
    }

    public void setRowFormat(Object rowFormat) {
        this.rowFormat = rowFormat;
    }

    @Basic
    @Column(name = "TABLE_ROWS")
    public Object getTableRows() {
        return tableRows;
    }

    public void setTableRows(Object tableRows) {
        this.tableRows = tableRows;
    }

    @Basic
    @Column(name = "AVG_ROW_LENGTH")
    public Object getAvgRowLength() {
        return avgRowLength;
    }

    public void setAvgRowLength(Object avgRowLength) {
        this.avgRowLength = avgRowLength;
    }

    @Basic
    @Column(name = "DATA_LENGTH")
    public Object getDataLength() {
        return dataLength;
    }

    public void setDataLength(Object dataLength) {
        this.dataLength = dataLength;
    }

    @Basic
    @Column(name = "MAX_DATA_LENGTH")
    public Object getMaxDataLength() {
        return maxDataLength;
    }

    public void setMaxDataLength(Object maxDataLength) {
        this.maxDataLength = maxDataLength;
    }

    @Basic
    @Column(name = "INDEX_LENGTH")
    public Object getIndexLength() {
        return indexLength;
    }

    public void setIndexLength(Object indexLength) {
        this.indexLength = indexLength;
    }

    @Basic
    @Column(name = "DATA_FREE")
    public Object getDataFree() {
        return dataFree;
    }

    public void setDataFree(Object dataFree) {
        this.dataFree = dataFree;
    }

    @Basic
    @Column(name = "AUTO_INCREMENT")
    public Object getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(Object autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "UPDATE_TIME")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "CHECK_TIME")
    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    @Basic
    @Column(name = "TABLE_COLLATION")
    public String getTableCollation() {
        return tableCollation;
    }

    public void setTableCollation(String tableCollation) {
        this.tableCollation = tableCollation;
    }

    @Basic
    @Column(name = "CHECKSUM")
    public Long getChecksum() {
        return checksum;
    }

    public void setChecksum(Long checksum) {
        this.checksum = checksum;
    }

    @Basic
    @Column(name = "CREATE_OPTIONS")
    public String getCreateOptions() {
        return createOptions;
    }

    public void setCreateOptions(String createOptions) {
        this.createOptions = createOptions;
    }

    @Basic
    @Column(name = "TABLE_COMMENT")
    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TablesEntity that = (TablesEntity) o;
        return Objects.equals(tableCatalog, that.tableCatalog) && Objects.equals(tableSchema, that.tableSchema) && Objects.equals(tableName, that.tableName) && Objects.equals(tableType, that.tableType) && Objects.equals(engine, that.engine) && Objects.equals(version, that.version) && Objects.equals(rowFormat, that.rowFormat) && Objects.equals(tableRows, that.tableRows) && Objects.equals(avgRowLength, that.avgRowLength) && Objects.equals(dataLength, that.dataLength) && Objects.equals(maxDataLength, that.maxDataLength) && Objects.equals(indexLength, that.indexLength) && Objects.equals(dataFree, that.dataFree) && Objects.equals(autoIncrement, that.autoIncrement) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(checkTime, that.checkTime) && Objects.equals(tableCollation, that.tableCollation) && Objects.equals(checksum, that.checksum) && Objects.equals(createOptions, that.createOptions) && Objects.equals(tableComment, that.tableComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableCatalog, tableSchema, tableName, tableType, engine, version, rowFormat, tableRows, avgRowLength, dataLength, maxDataLength, indexLength, dataFree, autoIncrement, createTime, updateTime, checkTime, tableCollation, checksum, createOptions, tableComment);
    }
}
