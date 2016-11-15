/*************************************************************/
/* Copyright (C) 2016, PERRINN Limited.  All Rights Reserved */
/*                                                           */
/* This software is distributed under the Apache 2.0 license */
/* For usage rights, please contact contact@perrinn.com      */
/*                                                           */
/*************************************************************/
/* This module developed by Christopher Moran                */
/*************************************************************/

package com.perrinn.appservice.controllers;
import com.perrinn.appservice.geo.Country;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountryController {

	@RequestMapping(value="/Country/GetByCode", method=RequestMethod.GET)
	public @ResponseBody String getCountryByCode(@RequestParam("CC") String sCode) {
		String template = "{ \"%s\": \"%s\", \"%s\": \"%s\" }";

		System.out.println("in CountryController::getCountryByCode");
		Country c = new Country();
		c.setCountryCode(sCode);
		c.loadByCode();
		return String.format(template, "CountryId", String.valueOf(c.getId()), "CountryName", c.getCountryName());
	}

	@RequestMapping(value="/Country/GetById", method=RequestMethod.GET)
	public @ResponseBody String getCountryById(@RequestParam("CI") int id) {
		String template = "{ \"%s\": \"%s\", \"%s\": \"%s\" }";

		Country c = new Country();
		c.setId(id);
		return String.format(template, "CountryCode", String.valueOf(c.getCountryCode()), "CountryName", c.getCountryName());
	}

	@RequestMapping(value="/Country/GetByName", method=RequestMethod.GET)
	public @ResponseBody String getCountry(@RequestParam("CN") String sName) {
		String template = "{ \"%s\": \"%s\", \"%s\": \"%s\" }";

		Country c = new Country();
		c.setCountryName(sName);
		return String.format(template, "CountryId", String.valueOf(c.getId()), "CountryCode", c.getCountryCode());
	}

	@RequestMapping(value="/Country/CheckDivision", method=RequestMethod.GET)
	public @ResponseBody String getCheckDivision(@RequestParam("CC") String sCode) {
		String template = "{ \"%s\": \"%s\", \"%s\": \"%s\" }";

		Country c = new Country();
		c.setCountryCode(sCode);
		return String.format(template, "Division", String.valueOf(c.getHasDivision()), "DivisionName", c.getDivisionName());
	}
}
