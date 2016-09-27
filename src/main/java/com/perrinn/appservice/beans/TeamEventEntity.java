package com.perrinn.appservice.beans;

/**
 * Created by alessandrosilacci on 27/09/16.
 */
public class TeamEventEntity {
    private int team;
    private int event;

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamEventEntity that = (TeamEventEntity) o;

        if (team != that.team) return false;
        if (event != that.event) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = team;
        result = 31 * result + event;
        return result;
    }
}
