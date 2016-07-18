package com.perrinn.appservice.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="team")
public class Team {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private long teamOwner;
	private String teamName;

	// Getters
	public long getId() {
		return this.id;
	}

	public long getTeamOwner() {
		return this.teamOwner;
	}

	public String getTeamName() {
		return this.teamName;
	}

	// Setters
	public void setId(long value) {
		this.id = value;
	}

	public void setTeamOwner(long value) {
		this.teamOwner = value;
	}

	public void setTeamName(String value) {
		this.teamName = value;
	}

	private void initLocals() {
		this.id = 0;
		this.teamOwner = 0;
		this.teamName = null;
	}

	public Team() {
		this.initLocals();
	}

	public Team(long id) {
		this.initLocals();
		this.id = id;
	}

	public Team(String name) {
		this.initLocals();
		this.teamName = name;
	}
}