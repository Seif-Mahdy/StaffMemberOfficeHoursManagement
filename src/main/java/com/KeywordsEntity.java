package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "KEYWORDS", schema = "information_schema", catalog = "")
public class KeywordsEntity {
    private String word;
    private Integer reserved;

    @Basic
    @Column(name = "WORD")
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Basic
    @Column(name = "RESERVED")
    public Integer getReserved() {
        return reserved;
    }

    public void setReserved(Integer reserved) {
        this.reserved = reserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeywordsEntity that = (KeywordsEntity) o;
        return Objects.equals(word, that.word) && Objects.equals(reserved, that.reserved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, reserved);
    }
}
