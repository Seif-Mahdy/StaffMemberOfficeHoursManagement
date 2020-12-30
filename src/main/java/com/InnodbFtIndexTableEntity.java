package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "INNODB_FT_INDEX_TABLE", schema = "information_schema", catalog = "")
public class InnodbFtIndexTableEntity {
    private String word;
    private Object firstDocId;
    private Object lastDocId;
    private Object docCount;
    private Object docId;
    private Object position;

    @Basic
    @Column(name = "WORD")
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Basic
    @Column(name = "FIRST_DOC_ID")
    public Object getFirstDocId() {
        return firstDocId;
    }

    public void setFirstDocId(Object firstDocId) {
        this.firstDocId = firstDocId;
    }

    @Basic
    @Column(name = "LAST_DOC_ID")
    public Object getLastDocId() {
        return lastDocId;
    }

    public void setLastDocId(Object lastDocId) {
        this.lastDocId = lastDocId;
    }

    @Basic
    @Column(name = "DOC_COUNT")
    public Object getDocCount() {
        return docCount;
    }

    public void setDocCount(Object docCount) {
        this.docCount = docCount;
    }

    @Basic
    @Column(name = "DOC_ID")
    public Object getDocId() {
        return docId;
    }

    public void setDocId(Object docId) {
        this.docId = docId;
    }

    @Basic
    @Column(name = "POSITION")
    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnodbFtIndexTableEntity that = (InnodbFtIndexTableEntity) o;
        return Objects.equals(word, that.word) && Objects.equals(firstDocId, that.firstDocId) && Objects.equals(lastDocId, that.lastDocId) && Objects.equals(docCount, that.docCount) && Objects.equals(docId, that.docId) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, firstDocId, lastDocId, docCount, docId, position);
    }
}
