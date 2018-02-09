package com.neuedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.pojos.Cloud;
import com.neuedu.service.CloudService;

@Controller
@RequestMapping("hello")
public class QueryServ {

	public QueryServ() {
		
	}
	@Autowired
	private CloudService cs;
	@RequestMapping("/query.do")
	public String queryFile(ModelMap m)
	{
		List<Cloud> queryFiles = cs.queryFiles();
		for (Cloud cloud : queryFiles) {
			System.out.println(cloud);
		}
		m.addAttribute("lists", queryFiles);
		return "queryFile";
	}

}
