package com;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "RESOURCE_GROUPS", schema = "information_schema", catalog = "")
public class ResourceGroupsEntity {
    private String resourceGroupName;
    private Object resourceGroupType;
    private byte resourceGroupEnabled;
    private byte[] vcpuIds;
    private int threadPriority;

    @Basic
    @Column(name = "RESOURCE_GROUP_NAME")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    @Basic
    @Column(name = "RESOURCE_GROUP_TYPE")
    public Object getResourceGroupType() {
        return resourceGroupType;
    }

    public void setResourceGroupType(Object resourceGroupType) {
        this.resourceGroupType = resourceGroupType;
    }

    @Basic
    @Column(name = "RESOURCE_GROUP_ENABLED")
    public byte getResourceGroupEnabled() {
        return resourceGroupEnabled;
    }

    public void setResourceGroupEnabled(byte resourceGroupEnabled) {
        this.resourceGroupEnabled = resourceGroupEnabled;
    }

    @Basic
    @Column(name = "VCPU_IDS")
    public byte[] getVcpuIds() {
        return vcpuIds;
    }

    public void setVcpuIds(byte[] vcpuIds) {
        this.vcpuIds = vcpuIds;
    }

    @Basic
    @Column(name = "THREAD_PRIORITY")
    public int getThreadPriority() {
        return threadPriority;
    }

    public void setThreadPriority(int threadPriority) {
        this.threadPriority = threadPriority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceGroupsEntity that = (ResourceGroupsEntity) o;
        return resourceGroupEnabled == that.resourceGroupEnabled && threadPriority == that.threadPriority && Objects.equals(resourceGroupName, that.resourceGroupName) && Objects.equals(resourceGroupType, that.resourceGroupType) && Arrays.equals(vcpuIds, that.vcpuIds);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(resourceGroupName, resourceGroupType, resourceGroupEnabled, threadPriority);
        result = 31 * result + Arrays.hashCode(vcpuIds);
        return result;
    }
}
