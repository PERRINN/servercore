package com.perrinn.appservice.beans;

import java.sql.Date;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class CityEntity {
    private int id;
    private Date createDate;
    private Integer createId;
    private Date changeDate;
    private Integer changeId;
    private byte active;
    private int country;
    private int region;
    private String cityName;

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

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (id != that.id) return false;
        if (active != that.active) return false;
        if (country != that.country) return false;
        if (region != that.region) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createId != null ? !createId.equals(that.createId) : that.createId != null) return false;
        if (changeDate != null ? !changeDate.equals(that.changeDate) : that.changeDate != null) return false;
        if (changeId != null ? !changeId.equals(that.changeId) : that.changeId != null) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;

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
        result = 31 * result + country;
        result = 31 * result + region;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }
}
