package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ST_UNITS_OF_MEASURE", schema = "information_schema", catalog = "")
public class StUnitsOfMeasureEntity {
    private String unitName;
    private String unitType;
    private Double conversionFactor;
    private String description;

    @Basic
    @Column(name = "UNIT_NAME")
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Basic
    @Column(name = "UNIT_TYPE")
    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Basic
    @Column(name = "CONVERSION_FACTOR")
    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StUnitsOfMeasureEntity that = (StUnitsOfMeasureEntity) o;
        return Objects.equals(unitName, that.unitName) && Objects.equals(unitType, that.unitType) && Objects.equals(conversionFactor, that.conversionFactor) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitName, unitType, conversionFactor, description);
    }
}
