package com.neuedu.pojos;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Cloud{


	private Integer id;
	
	private String filename;
	
	private String filesize;
	
	private Timestamp createdate;
	

}
