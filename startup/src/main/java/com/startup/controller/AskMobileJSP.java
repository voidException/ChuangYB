package com.startup.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value="/mobile")
public class AskMobileJSP {
	
	@RequestMapping(value="/webview")
	public String ask(){
		return "/front/ask";
	}
	

}
