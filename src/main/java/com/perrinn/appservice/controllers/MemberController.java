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

import com.perrinn.appservice.beans.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@RequestMapping(value="/Member/LogMeIn", method=RequestMethod.GET)
	public @ResponseBody String logMeIn(@RequestParam("MI") String sMid, @RequestParam("MH") String sHash) {
		String template = "{ \"%s\": \"%s\", \"%s\": \"%s\" }";

		Member m = new Member();
		if(m.logIn(sMid, sHash) == false) {
			return String.format(template, "Member", String.valueOf(m.getId()), "AuthState", "OK");
		}
		else {
			return String.format(template, "Member", String.valueOf(m.getId()), "AuthState", "NONE");
		}
	}

	@RequestMapping(value="/Member/SignMeUp", method=RequestMethod.GET)
	public @ResponseBody String signMeUp(@RequestParam("MI") String sMid, @RequestParam("MH") String sHash) {
		String template = "{ \"%s\": \"%s\", \"%s\": \"%s\" }";

		Member m = new Member();
		if(m.signUp(sMid, sHash) == false) {
			return String.format(template, "Member", String.valueOf(m.getId()), "AuthState", "OK");
		}
		else {
			return String.format(template, "Member", String.valueOf(m.getId()), "AuthState", "NONE");
		}
	}
}