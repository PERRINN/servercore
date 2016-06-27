/*************************************************************/
/* Copyright (C) 2016, PERRINN Limited.  All Rights Reserved */
/*                                                           */
/* This software is distributed under the Apache 2.0 license */
/* For usage rights, please contact contact@perrinn.com      */
/*                                                           */
/*************************************************************/
package com.perrinn.appservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/User/NewKey")
public class KeysController {
	private static final String template = "{ \"%s\": \"%s\",\"%s\": \"%s\" }";
	
	@RequestMapping(value="/User/NewKey", method=RequestMethod.GET)
	public @ResponseBody String ShowKey() {
		Keys k = new Keys();
		return String.format(template, "KeyVal", k.getKeyData(), "Ttl", "600");
	}

	// BUGBUG:
	// This is a stub function only.
	// Actual key processing has yet to be written
	@RequestMapping(value="/User/SetKey", method=RequestMethod.GET)
	public @ResponseBody String SetKey(@RequestParam("SKey") String sKey, @RequestParam("UKey") String uKey) {
		return String.format(template, "KeyVal", uKey, "Status", "Set");
	}
}
