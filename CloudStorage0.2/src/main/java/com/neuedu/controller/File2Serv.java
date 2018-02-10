package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class File2Serv {

	public File2Serv() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("File2.do")
	public String getFile2()
	{
		return "File2";
	}

}
