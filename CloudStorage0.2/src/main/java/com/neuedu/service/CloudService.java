package com.neuedu.service;

import java.util.List;

import com.neuedu.pojos.Cloud;


public interface CloudService {

	public List<Cloud> queryFiles();
	
	public void addFile(String filename,String filessize);
	
	public String getFileName(int id);
}
