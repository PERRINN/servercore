package com.perrinn.appservice.beans;

import java.sql.Date;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class TeamEntity {
    private int id;
    private Date createDate;
    private Integer createId;
    private Date changeDate;
    private Integer changeId;
    private byte active;
    private String teamName;
    private String address;
    private short status;
    private int organisation;
    private int timezone;
    private int backgroundImage;
    private int wallet;

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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public int getOrganisation() {
        return organisation;
    }

    public void setOrganisation(int organisation) {
        this.organisation = organisation;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(int backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamEntity that = (TeamEntity) o;

        if (id != that.id) return false;
        if (active != that.active) return false;
        if (status != that.status) return false;
        if (organisation != that.organisation) return false;
        if (timezone != that.timezone) return false;
        if (backgroundImage != that.backgroundImage) return false;
        if (wallet != that.wallet) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createId != null ? !createId.equals(that.createId) : that.createId != null) return false;
        if (changeDate != null ? !changeDate.equals(that.changeDate) : that.changeDate != null) return false;
        if (changeId != null ? !changeId.equals(that.changeId) : that.changeId != null) return false;
        if (teamName != null ? !teamName.equals(that.teamName) : that.teamName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

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
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + organisation;
        result = 31 * result + timezone;
        result = 31 * result + backgroundImage;
        result = 31 * result + wallet;
        return result;
    }
}
