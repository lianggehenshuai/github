package com.neuedu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.service.CloudService;

@Controller
@RequestMapping("hello")
public class DownLoadController {

	public DownLoadController() {
		
	}
	@Autowired
	private CloudService cs;
	
	@RequestMapping("/down.do")
	public String getDownLoad(HttpServletRequest request,ModelMap m)
	{
		String id = request.getParameter("id");
		int parseInt = Integer.parseInt(id);
		String fileName = cs.getFileName(parseInt);
		boolean downLoad = downLoad(fileName);
		if(downLoad==true)
		{
			m.addAttribute("result", "下载成功");
			return "redirect:query.do?result=成功";
		}else
		{
			m.addAttribute("result","下载失败");			
		}
		return "redirect:query.do";
	}
	
	/**
	 * 文件下载
	 * @param args
	 */
	public boolean downLoad(String fileName)
	{
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS","hdfs://192.168.83.131:9000");
		Path path = new Path("/hehe/"+fileName);
		File outFile = new File("D:\\"+fileName);
		try
		{
			OutputStream fso = new FileOutputStream(outFile); 
			FileSystem fs = FileSystem.get(conf);
			FSDataInputStream fsis = fs.open(path);
			int len = 0;
			byte[] b = new byte[1024];
			while((len=fsis.read(b))>0)
			{
				fso.write(b, 0, len);
			}
			fso.flush();
			fso.close();
			fsis.close();
			return true;
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
