package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "COLLATIONS", schema = "information_schema", catalog = "")
public class CollationsEntity {
    private String collationName;
    private String characterSetName;
    private Object id;
    private String isDefault;
    private String isCompiled;
    private Object sortlen;
    private Object padAttribute;

    @Basic
    @Column(name = "COLLATION_NAME")
    public String getCollationName() {
        return collationName;
    }

    public void setCollationName(String collationName) {
        this.collationName = collationName;
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
    @Column(name = "ID")
    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IS_DEFAULT")
    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Basic
    @Column(name = "IS_COMPILED")
    public String getIsCompiled() {
        return isCompiled;
    }

    public void setIsCompiled(String isCompiled) {
        this.isCompiled = isCompiled;
    }

    @Basic
    @Column(name = "SORTLEN")
    public Object getSortlen() {
        return sortlen;
    }

    public void setSortlen(Object sortlen) {
        this.sortlen = sortlen;
    }

    @Basic
    @Column(name = "PAD_ATTRIBUTE")
    public Object getPadAttribute() {
        return padAttribute;
    }

    public void setPadAttribute(Object padAttribute) {
        this.padAttribute = padAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollationsEntity that = (CollationsEntity) o;
        return Objects.equals(collationName, that.collationName) && Objects.equals(characterSetName, that.characterSetName) && Objects.equals(id, that.id) && Objects.equals(isDefault, that.isDefault) && Objects.equals(isCompiled, that.isCompiled) && Objects.equals(sortlen, that.sortlen) && Objects.equals(padAttribute, that.padAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collationName, characterSetName, id, isDefault, isCompiled, sortlen, padAttribute);
    }
}
