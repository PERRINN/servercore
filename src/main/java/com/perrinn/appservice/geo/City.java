/*************************************************************/
/* Copyright (C) 2016, PERRINN Limited.  All Rights Reserved */
/*                                                           */
/* This software is distributed under the Apache 2.0 license */
/* For usage rights, please contact contact@perrinn.com      */
/*                                                           */
/*************************************************************/
/* This module developed by Christopher Moran                */
/*************************************************************/

package com.perrinn.appservice.geo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private long countryId;
	private long regionId;
	private String cityName;

	// Getters
	public long getId() {
		return this.id;
	}

	public long getCountryId() {
		return this.countryId;
	}

	public long getRegionId() {
		return this.regionId;
	}

	public String getCityName() {
		return this.cityName;
	}

	// Setters
	public void setId(long value) {
		this.id = value;
	}

	public void setCountryId(long value) {
		this.countryId = value;
	}

	public void setRegionId(long value) {
		this.regionId = value;
	}

	public void setCityName(String value) {
		this.cityName = value;
	}

	private void initLocals() {
		this.id = 0;
		this.countryId = 0;
		this.regionId = 0;
		this.cityName = null;
	}

	public City() {
		this.initLocals();
	}

	public City(long id) {
		this.initLocals();
		this.id = id;
	}
}