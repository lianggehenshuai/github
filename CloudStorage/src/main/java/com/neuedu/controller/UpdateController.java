package com.neuedu.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.service.CloudService;

@Controller
@RequestMapping("hello")
public class UpdateController {
	
	/**
	 * 功能: 调用Service层
	 * 作者: Yy
	 * 创建日期:2018年2月8日
	 * @param f
	 * @param m
	 * @return
	 */
	@Autowired
	private CloudService cs;
	
	@RequestMapping("update.do")
	public String getFile(MultipartFile f,ModelMap m)
	{
		try {
			String fileSize = Long.toString(f.getSize());
			cs.addFile(f.getOriginalFilename(), fileSize);
			boolean upLoad = upLoad(f.getInputStream(), f.getOriginalFilename());
			if(upLoad==true)
			{
				m.addAttribute("message", "上传成功");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	/**
	 * 文件上传方法
	 */
	public boolean upLoad(InputStream is,String fileName)
	{
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.83.131:9000");
		
		Path path = new Path("/hehe/"+fileName+"/");
		try {
			FileSystem fs = FileSystem.get(conf);
			FSDataOutputStream out = fs.create(path);
			byte[] b = new byte[1024];
			int len = 0;
			while((len=is.read(b,0,b.length))>0)
			{
				out.write(b);
			}
			out.flush();
			out.close();
			is.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
