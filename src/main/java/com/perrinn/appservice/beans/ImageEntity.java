package com.perrinn.appservice.beans;

import java.sql.Date;
import java.util.Arrays;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class ImageEntity {
    private int id;
    private Date createDate;
    private Integer createId;
    private Date changeDate;
    private Integer changeId;
    private int owner;
    private int team;
    private byte[] imageContent;
    private String imageStamp;
    private String imageName;
    private Integer xSize;
    private Integer ySize;

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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public byte[] getImageContent() {
        return imageContent;
    }

    public void setImageContent(byte[] imageContent) {
        this.imageContent = imageContent;
    }

    public String getImageStamp() {
        return imageStamp;
    }

    public void setImageStamp(String imageStamp) {
        this.imageStamp = imageStamp;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getxSize() {
        return xSize;
    }

    public void setxSize(Integer xSize) {
        this.xSize = xSize;
    }

    public Integer getySize() {
        return ySize;
    }

    public void setySize(Integer ySize) {
        this.ySize = ySize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageEntity that = (ImageEntity) o;

        if (id != that.id) return false;
        if (owner != that.owner) return false;
        if (team != that.team) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createId != null ? !createId.equals(that.createId) : that.createId != null) return false;
        if (changeDate != null ? !changeDate.equals(that.changeDate) : that.changeDate != null) return false;
        if (changeId != null ? !changeId.equals(that.changeId) : that.changeId != null) return false;
        if (!Arrays.equals(imageContent, that.imageContent)) return false;
        if (imageStamp != null ? !imageStamp.equals(that.imageStamp) : that.imageStamp != null) return false;
        if (imageName != null ? !imageName.equals(that.imageName) : that.imageName != null) return false;
        if (xSize != null ? !xSize.equals(that.xSize) : that.xSize != null) return false;
        if (ySize != null ? !ySize.equals(that.ySize) : that.ySize != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createId != null ? createId.hashCode() : 0);
        result = 31 * result + (changeDate != null ? changeDate.hashCode() : 0);
        result = 31 * result + (changeId != null ? changeId.hashCode() : 0);
        result = 31 * result + owner;
        result = 31 * result + team;
        result = 31 * result + Arrays.hashCode(imageContent);
        result = 31 * result + (imageStamp != null ? imageStamp.hashCode() : 0);
        result = 31 * result + (imageName != null ? imageName.hashCode() : 0);
        result = 31 * result + (xSize != null ? xSize.hashCode() : 0);
        result = 31 * result + (ySize != null ? ySize.hashCode() : 0);
        return result;
    }
}
