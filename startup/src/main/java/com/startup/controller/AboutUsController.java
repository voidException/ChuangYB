package com.startup.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value="/more")
public class AboutUsController  {	
	
	@RequestMapping("/aboutUs")	
    public String aboutUs(){
    	return "/back/aboutUs";
    }   
	@RequestMapping(value="/advise")
	public String advise(){
		return "/back/advise";
	}

	@RequestMapping(value="/webview")
	public String ask(){
		return "/front/ask";
	}
	@RequestMapping(value="/login")
	public String login(){
		return "/front/loginUser";
	}
	@RequestMapping(value="/register")
	public String register(){
		return "/front/registerUser";
	}
	@RequestMapping(value="/findPassword")
	public String secret(){
		return "front/secret";
	}
	
}
