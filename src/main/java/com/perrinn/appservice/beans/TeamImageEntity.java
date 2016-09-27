package com.perrinn.appservice.beans;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class TeamImageEntity {
    private int team;
    private int image;

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamImageEntity that = (TeamImageEntity) o;

        if (team != that.team) return false;
        if (image != that.image) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = team;
        result = 31 * result + image;
        return result;
    }
}
