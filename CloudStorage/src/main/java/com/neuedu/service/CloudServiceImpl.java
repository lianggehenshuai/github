package com.neuedu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neuedu.dao.CloudDao;
import com.neuedu.pojos.Cloud;

@Service
public class CloudServiceImpl implements CloudService {

	@Resource
	private CloudDao cm;
	
	
	public CloudServiceImpl() {
	}

	@Override
	public List<Cloud> queryFiles() {
		return cm.queryFiles();
	}

	@Override
	public void addFile(String fileName, String fileSize) {
		cm.addFile(fileName, fileSize);	
	}

	@Override
	public String getFileName(int id) {
		return cm.downLoad(id);
	}
}
