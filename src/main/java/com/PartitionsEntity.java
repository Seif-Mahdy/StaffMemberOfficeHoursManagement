package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PARTITIONS", schema = "information_schema", catalog = "")
public class PartitionsEntity {
    private String tableCatalog;
    private String tableSchema;
    private String tableName;
    private String partitionName;
    private String subpartitionName;
    private Object partitionOrdinalPosition;
    private Object subpartitionOrdinalPosition;
    private String partitionMethod;
    private String subpartitionMethod;
    private String partitionExpression;
    private String subpartitionExpression;
    private String partitionDescription;
    private Object tableRows;
    private Object avgRowLength;
    private Object dataLength;
    private Object maxDataLength;
    private Object indexLength;
    private Object dataFree;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp checkTime;
    private Long checksum;
    private String partitionComment;
    private String nodegroup;
    private String tablespaceName;

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
    @Column(name = "PARTITION_NAME")
    public String getPartitionName() {
        return partitionName;
    }

    public void setPartitionName(String partitionName) {
        this.partitionName = partitionName;
    }

    @Basic
    @Column(name = "SUBPARTITION_NAME")
    public String getSubpartitionName() {
        return subpartitionName;
    }

    public void setSubpartitionName(String subpartitionName) {
        this.subpartitionName = subpartitionName;
    }

    @Basic
    @Column(name = "PARTITION_ORDINAL_POSITION")
    public Object getPartitionOrdinalPosition() {
        return partitionOrdinalPosition;
    }

    public void setPartitionOrdinalPosition(Object partitionOrdinalPosition) {
        this.partitionOrdinalPosition = partitionOrdinalPosition;
    }

    @Basic
    @Column(name = "SUBPARTITION_ORDINAL_POSITION")
    public Object getSubpartitionOrdinalPosition() {
        return subpartitionOrdinalPosition;
    }

    public void setSubpartitionOrdinalPosition(Object subpartitionOrdinalPosition) {
        this.subpartitionOrdinalPosition = subpartitionOrdinalPosition;
    }

    @Basic
    @Column(name = "PARTITION_METHOD")
    public String getPartitionMethod() {
        return partitionMethod;
    }

    public void setPartitionMethod(String partitionMethod) {
        this.partitionMethod = partitionMethod;
    }

    @Basic
    @Column(name = "SUBPARTITION_METHOD")
    public String getSubpartitionMethod() {
        return subpartitionMethod;
    }

    public void setSubpartitionMethod(String subpartitionMethod) {
        this.subpartitionMethod = subpartitionMethod;
    }

    @Basic
    @Column(name = "PARTITION_EXPRESSION")
    public String getPartitionExpression() {
        return partitionExpression;
    }

    public void setPartitionExpression(String partitionExpression) {
        this.partitionExpression = partitionExpression;
    }

    @Basic
    @Column(name = "SUBPARTITION_EXPRESSION")
    public String getSubpartitionExpression() {
        return subpartitionExpression;
    }

    public void setSubpartitionExpression(String subpartitionExpression) {
        this.subpartitionExpression = subpartitionExpression;
    }

    @Basic
    @Column(name = "PARTITION_DESCRIPTION")
    public String getPartitionDescription() {
        return partitionDescription;
    }

    public void setPartitionDescription(String partitionDescription) {
        this.partitionDescription = partitionDescription;
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
    @Column(name = "CHECKSUM")
    public Long getChecksum() {
        return checksum;
    }

    public void setChecksum(Long checksum) {
        this.checksum = checksum;
    }

    @Basic
    @Column(name = "PARTITION_COMMENT")
    public String getPartitionComment() {
        return partitionComment;
    }

    public void setPartitionComment(String partitionComment) {
        this.partitionComment = partitionComment;
    }

    @Basic
    @Column(name = "NODEGROUP")
    public String getNodegroup() {
        return nodegroup;
    }

    public void setNodegroup(String nodegroup) {
        this.nodegroup = nodegroup;
    }

    @Basic
    @Column(name = "TABLESPACE_NAME")
    public String getTablespaceName() {
        return tablespaceName;
    }

    public void setTablespaceName(String tablespaceName) {
        this.tablespaceName = tablespaceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartitionsEntity that = (PartitionsEntity) o;
        return Objects.equals(tableCatalog, that.tableCatalog) && Objects.equals(tableSchema, that.tableSchema) && Objects.equals(tableName, that.tableName) && Objects.equals(partitionName, that.partitionName) && Objects.equals(subpartitionName, that.subpartitionName) && Objects.equals(partitionOrdinalPosition, that.partitionOrdinalPosition) && Objects.equals(subpartitionOrdinalPosition, that.subpartitionOrdinalPosition) && Objects.equals(partitionMethod, that.partitionMethod) && Objects.equals(subpartitionMethod, that.subpartitionMethod) && Objects.equals(partitionExpression, that.partitionExpression) && Objects.equals(subpartitionExpression, that.subpartitionExpression) && Objects.equals(partitionDescription, that.partitionDescription) && Objects.equals(tableRows, that.tableRows) && Objects.equals(avgRowLength, that.avgRowLength) && Objects.equals(dataLength, that.dataLength) && Objects.equals(maxDataLength, that.maxDataLength) && Objects.equals(indexLength, that.indexLength) && Objects.equals(dataFree, that.dataFree) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(checkTime, that.checkTime) && Objects.equals(checksum, that.checksum) && Objects.equals(partitionComment, that.partitionComment) && Objects.equals(nodegroup, that.nodegroup) && Objects.equals(tablespaceName, that.tablespaceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableCatalog, tableSchema, tableName, partitionName, subpartitionName, partitionOrdinalPosition, subpartitionOrdinalPosition, partitionMethod, subpartitionMethod, partitionExpression, subpartitionExpression, partitionDescription, tableRows, avgRowLength, dataLength, maxDataLength, indexLength, dataFree, createTime, updateTime, checkTime, checksum, partitionComment, nodegroup, tablespaceName);
    }
}
