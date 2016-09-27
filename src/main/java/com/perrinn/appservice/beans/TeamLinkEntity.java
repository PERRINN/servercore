package com.perrinn.appservice.beans;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class TeamLinkEntity {
    private int team;
    private int link;

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamLinkEntity that = (TeamLinkEntity) o;

        if (team != that.team) return false;
        if (link != that.link) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = team;
        result = 31 * result + link;
        return result;
    }
}
