package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ST_SPATIAL_REFERENCE_SYSTEMS", schema = "information_schema", catalog = "")
public class StSpatialReferenceSystemsEntity {
    private String srsName;
    private Object srsId;
    private String organization;
    private Object organizationCoordsysId;
    private String definition;
    private String description;

    @Basic
    @Column(name = "SRS_NAME")
    public String getSrsName() {
        return srsName;
    }

    public void setSrsName(String srsName) {
        this.srsName = srsName;
    }

    @Basic
    @Column(name = "SRS_ID")
    public Object getSrsId() {
        return srsId;
    }

    public void setSrsId(Object srsId) {
        this.srsId = srsId;
    }

    @Basic
    @Column(name = "ORGANIZATION")
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Basic
    @Column(name = "ORGANIZATION_COORDSYS_ID")
    public Object getOrganizationCoordsysId() {
        return organizationCoordsysId;
    }

    public void setOrganizationCoordsysId(Object organizationCoordsysId) {
        this.organizationCoordsysId = organizationCoordsysId;
    }

    @Basic
    @Column(name = "DEFINITION")
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
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
        StSpatialReferenceSystemsEntity that = (StSpatialReferenceSystemsEntity) o;
        return Objects.equals(srsName, that.srsName) && Objects.equals(srsId, that.srsId) && Objects.equals(organization, that.organization) && Objects.equals(organizationCoordsysId, that.organizationCoordsysId) && Objects.equals(definition, that.definition) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(srsName, srsId, organization, organizationCoordsysId, definition, description);
    }
}
