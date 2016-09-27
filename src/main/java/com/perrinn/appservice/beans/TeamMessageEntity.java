package com.perrinn.appservice.beans;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class TeamMessageEntity {
    private int team;
    private int message;

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamMessageEntity that = (TeamMessageEntity) o;

        if (team != that.team) return false;
        if (message != that.message) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = team;
        result = 31 * result + message;
        return result;
    }
}
