/*************************************************************/
/* Copyright (C) 2016, PERRINN Limited.  All Rights Reserved */
/*                                                           */
/* This software is distributed under the Apache 2.0 license */
/* For usage rights, please contact contact@perrinn.com      */
/*                                                           */
/*************************************************************/
/* This module developed by Christopher Moran                */
/*************************************************************/

package com.perrinn.appservice.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@RequestMapping(value="/Member/LogMeIn", method=RequestMethod.GET)
	public @ResponseBody String getCheckDivision(@RequestParam("MI") String sMid) {
		String template = "{ \"%s\": \"%s\", \"%s\": \"%s\" }";

		Member m = new Member();

		return String.format(template, "Member", String.valueOf(m.getMemberId()), "AuthState", "NONE");
	}
}
