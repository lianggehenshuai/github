package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojos.Cloud;


public interface CloudDao {
	
	/**
	 * 功能: 添加文件
	 * 作者: Yy
	 * 创建日期:2018年2月8日
	 * @param fileName
	 * @param filesize
	 */
	public void addFile(String fileName,String filesize);

	/**
	 * 功能: 查询所有文件
 	 * 作者: Yy
	 * 创建日期:2018年2月8日
	 * @return
	 */
	public List<Cloud> queryFiles();
	/**
	 * 功能: 下载文件
	 * 作者: Yy
	 * 创建日期:2018年2月8日
	 * @param id
	 * @return
	 */
	public String downLoad(int id);
}
