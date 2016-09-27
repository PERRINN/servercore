package com.perrinn.appservice.beans;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class TeamActivityEntity {
    private int team;
    private int activity;

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamActivityEntity that = (TeamActivityEntity) o;

        if (team != that.team) return false;
        if (activity != that.activity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = team;
        result = 31 * result + activity;
        return result;
    }
}
