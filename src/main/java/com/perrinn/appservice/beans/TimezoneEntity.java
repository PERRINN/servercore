package com.perrinn.appservice.beans;

import java.sql.Date;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class TimezoneEntity {
    private int id;
    private Date createDate;
    private Integer createId;
    private Date changeDate;
    private Integer changeId;
    private byte active;
    private String timezone;
    private Integer tzOffset;
    private Byte hasDst;
    private Double dstStart;
    private Double dstEnd;
    private Integer dstOffset;

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

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getTzOffset() {
        return tzOffset;
    }

    public void setTzOffset(Integer tzOffset) {
        this.tzOffset = tzOffset;
    }

    public Byte getHasDst() {
        return hasDst;
    }

    public void setHasDst(Byte hasDst) {
        this.hasDst = hasDst;
    }

    public Double getDstStart() {
        return dstStart;
    }

    public void setDstStart(Double dstStart) {
        this.dstStart = dstStart;
    }

    public Double getDstEnd() {
        return dstEnd;
    }

    public void setDstEnd(Double dstEnd) {
        this.dstEnd = dstEnd;
    }

    public Integer getDstOffset() {
        return dstOffset;
    }

    public void setDstOffset(Integer dstOffset) {
        this.dstOffset = dstOffset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimezoneEntity that = (TimezoneEntity) o;

        if (id != that.id) return false;
        if (active != that.active) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createId != null ? !createId.equals(that.createId) : that.createId != null) return false;
        if (changeDate != null ? !changeDate.equals(that.changeDate) : that.changeDate != null) return false;
        if (changeId != null ? !changeId.equals(that.changeId) : that.changeId != null) return false;
        if (timezone != null ? !timezone.equals(that.timezone) : that.timezone != null) return false;
        if (tzOffset != null ? !tzOffset.equals(that.tzOffset) : that.tzOffset != null) return false;
        if (hasDst != null ? !hasDst.equals(that.hasDst) : that.hasDst != null) return false;
        if (dstStart != null ? !dstStart.equals(that.dstStart) : that.dstStart != null) return false;
        if (dstEnd != null ? !dstEnd.equals(that.dstEnd) : that.dstEnd != null) return false;
        if (dstOffset != null ? !dstOffset.equals(that.dstOffset) : that.dstOffset != null) return false;

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
        result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
        result = 31 * result + (tzOffset != null ? tzOffset.hashCode() : 0);
        result = 31 * result + (hasDst != null ? hasDst.hashCode() : 0);
        result = 31 * result + (dstStart != null ? dstStart.hashCode() : 0);
        result = 31 * result + (dstEnd != null ? dstEnd.hashCode() : 0);
        result = 31 * result + (dstOffset != null ? dstOffset.hashCode() : 0);
        return result;
    }
}
