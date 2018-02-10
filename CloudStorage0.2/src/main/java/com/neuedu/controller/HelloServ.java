package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloServ {

	
	@RequestMapping("/show.do")
	public String showHello()
	{
		return "index";
	}
}
