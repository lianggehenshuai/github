package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hi")
public class FileServ {

	public FileServ() {
		
	}
	@RequestMapping("/getFile")
	public String getFile()
	{
		return "File";
	}

}
