package com.perrinn.appservice.geo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String countryCode;
	private String countryName;
	private boolean hasDivision;
	private String divisionName;

	// Getters
	public long getId() {
		return this.id;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public boolean getHasDivision() {
		return this.hasDivision;
	}

	public String getDivisionName() {
		return this.divisionName;
	}

	// Setters
	public void setId(long value) {
		this.id = value;
	}

	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	public void setCountryName(String value) {
		this.countryName = value;
	}

	public void setHasDivision(boolean value) {
		this.hasDivision = value;
	}

	public void setDivisionName(String value) {
		this.divisionName = value;
	}

	private void initLocals() {
		this.id = 0;
		this.countryCode = null;
		this.countryName = null;
		this.hasDivision = false;
		this.divisionName = null;
	}

	public Country() {
		this.initLocals();
	}

	public Country(String code) {
		this.initLocals();
		this.countryCode = code;
	}

	public Country(long id) {
		this.initLocals();
		this.id = id;
	}
}