package com.perrinn.appservice.beans;

import java.sql.Date;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class KeyEntity {
    private int id;
    private Date createDate;
    private Integer createId;
    private Date changeDate;
    private Integer changeId;
    private byte active;
    private String devicetype;
    private String macAddress;
    private String deviceName;
    private Integer deviceType;
    private int profile;
    private Double deviceLat;
    private Double deviceLong;
    private int deviceTz;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Integer getChangeId() {
        return changeId;
    }

    public void setChangeId(Integer changeId) {
        this.changeId = changeId;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public Double getDeviceLat() {
        return deviceLat;
    }

    public void setDeviceLat(Double deviceLat) {
        this.deviceLat = deviceLat;
    }

    public Double getDeviceLong() {
        return deviceLong;
    }

    public void setDeviceLong(Double deviceLong) {
        this.deviceLong = deviceLong;
    }

    public int getDeviceTz() {
        return deviceTz;
    }

    public void setDeviceTz(int deviceTz) {
        this.deviceTz = deviceTz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyEntity keyEntity = (KeyEntity) o;

        if (id != keyEntity.id) return false;
        if (active != keyEntity.active) return false;
        if (profile != keyEntity.profile) return false;
        if (deviceTz != keyEntity.deviceTz) return false;
        if (createDate != null ? !createDate.equals(keyEntity.createDate) : keyEntity.createDate != null) return false;
        if (createId != null ? !createId.equals(keyEntity.createId) : keyEntity.createId != null) return false;
        if (changeDate != null ? !changeDate.equals(keyEntity.changeDate) : keyEntity.changeDate != null) return false;
        if (changeId != null ? !changeId.equals(keyEntity.changeId) : keyEntity.changeId != null) return false;
        if (devicetype != null ? !devicetype.equals(keyEntity.devicetype) : keyEntity.devicetype != null) return false;
        if (macAddress != null ? !macAddress.equals(keyEntity.macAddress) : keyEntity.macAddress != null) return false;
        if (deviceName != null ? !deviceName.equals(keyEntity.deviceName) : keyEntity.deviceName != null) return false;
        if (deviceType != null ? !deviceType.equals(keyEntity.deviceType) : keyEntity.deviceType != null) return false;
        if (deviceLat != null ? !deviceLat.equals(keyEntity.deviceLat) : keyEntity.deviceLat != null) return false;
        if (deviceLong != null ? !deviceLong.equals(keyEntity.deviceLong) : keyEntity.deviceLong != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createId != null ? createId.hashCode() : 0);
        result = 31 * result + (changeDate != null ? changeDate.hashCode() : 0);
        result = 31 * result + (changeId != null ? changeId.hashCode() : 0);
        result = 31 * result + (int) active;
        result = 31 * result + (devicetype != null ? devicetype.hashCode() : 0);
        result = 31 * result + (macAddress != null ? macAddress.hashCode() : 0);
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (deviceType != null ? deviceType.hashCode() : 0);
        result = 31 * result + profile;
        result = 31 * result + (deviceLat != null ? deviceLat.hashCode() : 0);
        result = 31 * result + (deviceLong != null ? deviceLong.hashCode() : 0);
        result = 31 * result + deviceTz;
        return result;
    }
}
