package com.perrinn.appservice.beans;

import java.sql.Date;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class TeamProfileEntity {
    private int id;
    private Date createDate;
    private Integer createId;
    private Date changeDate;
    private Integer changeId;
    private byte active;
    private Short leader;
    private int profile;
    private byte locationShared;
    private int team;

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

    public Short getLeader() {
        return leader;
    }

    public void setLeader(Short leader) {
        this.leader = leader;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public byte getLocationShared() {
        return locationShared;
    }

    public void setLocationShared(byte locationShared) {
        this.locationShared = locationShared;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamProfileEntity that = (TeamProfileEntity) o;

        if (id != that.id) return false;
        if (active != that.active) return false;
        if (profile != that.profile) return false;
        if (locationShared != that.locationShared) return false;
        if (team != that.team) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createId != null ? !createId.equals(that.createId) : that.createId != null) return false;
        if (changeDate != null ? !changeDate.equals(that.changeDate) : that.changeDate != null) return false;
        if (changeId != null ? !changeId.equals(that.changeId) : that.changeId != null) return false;
        if (leader != null ? !leader.equals(that.leader) : that.leader != null) return false;

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
        result = 31 * result + (leader != null ? leader.hashCode() : 0);
        result = 31 * result + profile;
        result = 31 * result + (int) locationShared;
        result = 31 * result + team;
        return result;
    }
}
