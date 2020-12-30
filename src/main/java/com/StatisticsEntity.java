package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "STATISTICS", schema = "information_schema", catalog = "")
public class StatisticsEntity {
    private String tableCatalog;
    private String tableSchema;
    private String tableName;
    private int nonUnique;
    private String indexSchema;
    private String indexName;
    private Object seqInIndex;
    private String columnName;
    private String collation;
    private Long cardinality;
    private Long subPart;
    private byte[] packed;
    private String nullable;
    private String indexType;
    private String comment;
    private String indexComment;
    private String isVisible;
    private String expression;

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
    @Column(name = "NON_UNIQUE")
    public int getNonUnique() {
        return nonUnique;
    }

    public void setNonUnique(int nonUnique) {
        this.nonUnique = nonUnique;
    }

    @Basic
    @Column(name = "INDEX_SCHEMA")
    public String getIndexSchema() {
        return indexSchema;
    }

    public void setIndexSchema(String indexSchema) {
        this.indexSchema = indexSchema;
    }

    @Basic
    @Column(name = "INDEX_NAME")
    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    @Basic
    @Column(name = "SEQ_IN_INDEX")
    public Object getSeqInIndex() {
        return seqInIndex;
    }

    public void setSeqInIndex(Object seqInIndex) {
        this.seqInIndex = seqInIndex;
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
    @Column(name = "COLLATION")
    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
    }

    @Basic
    @Column(name = "CARDINALITY")
    public Long getCardinality() {
        return cardinality;
    }

    public void setCardinality(Long cardinality) {
        this.cardinality = cardinality;
    }

    @Basic
    @Column(name = "SUB_PART")
    public Long getSubPart() {
        return subPart;
    }

    public void setSubPart(Long subPart) {
        this.subPart = subPart;
    }

    @Basic
    @Column(name = "PACKED")
    public byte[] getPacked() {
        return packed;
    }

    public void setPacked(byte[] packed) {
        this.packed = packed;
    }

    @Basic
    @Column(name = "NULLABLE")
    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    @Basic
    @Column(name = "INDEX_TYPE")
    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
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
    @Column(name = "INDEX_COMMENT")
    public String getIndexComment() {
        return indexComment;
    }

    public void setIndexComment(String indexComment) {
        this.indexComment = indexComment;
    }

    @Basic
    @Column(name = "IS_VISIBLE")
    public String getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(String isVisible) {
        this.isVisible = isVisible;
    }

    @Basic
    @Column(name = "EXPRESSION")
    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsEntity that = (StatisticsEntity) o;
        return nonUnique == that.nonUnique && Objects.equals(tableCatalog, that.tableCatalog) && Objects.equals(tableSchema, that.tableSchema) && Objects.equals(tableName, that.tableName) && Objects.equals(indexSchema, that.indexSchema) && Objects.equals(indexName, that.indexName) && Objects.equals(seqInIndex, that.seqInIndex) && Objects.equals(columnName, that.columnName) && Objects.equals(collation, that.collation) && Objects.equals(cardinality, that.cardinality) && Objects.equals(subPart, that.subPart) && Arrays.equals(packed, that.packed) && Objects.equals(nullable, that.nullable) && Objects.equals(indexType, that.indexType) && Objects.equals(comment, that.comment) && Objects.equals(indexComment, that.indexComment) && Objects.equals(isVisible, that.isVisible) && Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(tableCatalog, tableSchema, tableName, nonUnique, indexSchema, indexName, seqInIndex, columnName, collation, cardinality, subPart, nullable, indexType, comment, indexComment, isVisible, expression);
        result = 31 * result + Arrays.hashCode(packed);
        return result;
    }
}
