package com.perrinn.appservice.beans;

import java.sql.Date;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class ProfileEntity {
    private int id;
    private Date createDate;
    private Integer createId;
    private Date changeDate;
    private Integer changeId;
    private byte active;
    private Integer homeCountry;
    private Integer homeRegion;
    private Integer homeCity;
    private Double homeLat;
    private Double homeLong;
    private Integer homeTz;
    private Integer currCountry;
    private Integer currRegion;
    private Integer currCity;
    private Double currLat;
    private Double currLong;
    private Integer currTz;
    private String displayName;
    private Date dateOfBirth;
    private String firstName;
    private String surname;
    private int photo;

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

    public Integer getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(Integer homeCountry) {
        this.homeCountry = homeCountry;
    }

    public Integer getHomeRegion() {
        return homeRegion;
    }

    public void setHomeRegion(Integer homeRegion) {
        this.homeRegion = homeRegion;
    }

    public Integer getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(Integer homeCity) {
        this.homeCity = homeCity;
    }

    public Double getHomeLat() {
        return homeLat;
    }

    public void setHomeLat(Double homeLat) {
        this.homeLat = homeLat;
    }

    public Double getHomeLong() {
        return homeLong;
    }

    public void setHomeLong(Double homeLong) {
        this.homeLong = homeLong;
    }

    public Integer getHomeTz() {
        return homeTz;
    }

    public void setHomeTz(Integer homeTz) {
        this.homeTz = homeTz;
    }

    public Integer getCurrCountry() {
        return currCountry;
    }

    public void setCurrCountry(Integer currCountry) {
        this.currCountry = currCountry;
    }

    public Integer getCurrRegion() {
        return currRegion;
    }

    public void setCurrRegion(Integer currRegion) {
        this.currRegion = currRegion;
    }

    public Integer getCurrCity() {
        return currCity;
    }

    public void setCurrCity(Integer currCity) {
        this.currCity = currCity;
    }

    public Double getCurrLat() {
        return currLat;
    }

    public void setCurrLat(Double currLat) {
        this.currLat = currLat;
    }

    public Double getCurrLong() {
        return currLong;
    }

    public void setCurrLong(Double currLong) {
        this.currLong = currLong;
    }

    public Integer getCurrTz() {
        return currTz;
    }

    public void setCurrTz(Integer currTz) {
        this.currTz = currTz;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileEntity that = (ProfileEntity) o;

        if (id != that.id) return false;
        if (active != that.active) return false;
        if (photo != that.photo) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createId != null ? !createId.equals(that.createId) : that.createId != null) return false;
        if (changeDate != null ? !changeDate.equals(that.changeDate) : that.changeDate != null) return false;
        if (changeId != null ? !changeId.equals(that.changeId) : that.changeId != null) return false;
        if (homeCountry != null ? !homeCountry.equals(that.homeCountry) : that.homeCountry != null) return false;
        if (homeRegion != null ? !homeRegion.equals(that.homeRegion) : that.homeRegion != null) return false;
        if (homeCity != null ? !homeCity.equals(that.homeCity) : that.homeCity != null) return false;
        if (homeLat != null ? !homeLat.equals(that.homeLat) : that.homeLat != null) return false;
        if (homeLong != null ? !homeLong.equals(that.homeLong) : that.homeLong != null) return false;
        if (homeTz != null ? !homeTz.equals(that.homeTz) : that.homeTz != null) return false;
        if (currCountry != null ? !currCountry.equals(that.currCountry) : that.currCountry != null) return false;
        if (currRegion != null ? !currRegion.equals(that.currRegion) : that.currRegion != null) return false;
        if (currCity != null ? !currCity.equals(that.currCity) : that.currCity != null) return false;
        if (currLat != null ? !currLat.equals(that.currLat) : that.currLat != null) return false;
        if (currLong != null ? !currLong.equals(that.currLong) : that.currLong != null) return false;
        if (currTz != null ? !currTz.equals(that.currTz) : that.currTz != null) return false;
        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

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
        result = 31 * result + (homeCountry != null ? homeCountry.hashCode() : 0);
        result = 31 * result + (homeRegion != null ? homeRegion.hashCode() : 0);
        result = 31 * result + (homeCity != null ? homeCity.hashCode() : 0);
        result = 31 * result + (homeLat != null ? homeLat.hashCode() : 0);
        result = 31 * result + (homeLong != null ? homeLong.hashCode() : 0);
        result = 31 * result + (homeTz != null ? homeTz.hashCode() : 0);
        result = 31 * result + (currCountry != null ? currCountry.hashCode() : 0);
        result = 31 * result + (currRegion != null ? currRegion.hashCode() : 0);
        result = 31 * result + (currCity != null ? currCity.hashCode() : 0);
        result = 31 * result + (currLat != null ? currLat.hashCode() : 0);
        result = 31 * result + (currLong != null ? currLong.hashCode() : 0);
        result = 31 * result + (currTz != null ? currTz.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + photo;
        return result;
    }
}
