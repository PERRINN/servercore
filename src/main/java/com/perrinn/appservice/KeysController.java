package com.perrinn.appservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/User/NewKey")
public class KeysController {
	private static final String template = "{ \"KeyVal\": \"%s\",\"TTL\": \"%s\" }";
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody String ShowKey() {
		Keys k = new Keys(System.currentTimeMillis());
		return String.format(template, k.getKeyData(), "600");
	}
}
