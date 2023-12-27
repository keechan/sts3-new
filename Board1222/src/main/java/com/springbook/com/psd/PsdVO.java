package com.springbook.com.psd;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PsdVO {
	private int seq;
	private String title;
	private Date regDate;
	private MultipartFile uploadFile;
	private String uploadFileStr;
	private int cnt;
}
