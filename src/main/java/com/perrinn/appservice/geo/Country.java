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
	private boolean hasRegion;
	private String regionName;

	public Country(String code) {
		this.id = 0;
		if(code.length() == 0)
			this.countryCode = null;
		else
			this.countryCode = code;
		this.countryName = null;
		this.hasRegion = false;
		this.regionName = null;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long value) {
		this.id = value;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String value) {
		this.countryName = value;
	}

	public boolean getHasRegion() {
		return this.hasRegion;
	}

	public void setHasRegion(boolean value) {
		this.hasRegion = value;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String value) {
		this.regionName = value;
	}

	@Override
	public String toString() {
		return "id=" + String.valueOf(this.id) + ", countryCode=" + this.countryCode + ", countryName=" + this.countryName + ", hasRegion=" + String.valueOf(this.hasRegion) + ", regionName" + this.regionName;
	}
}