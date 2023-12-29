package com.springbook.com.member;

import lombok.Data;

@Data
public class MemberVO {	
    private String memberid;
    private String name;
    private String pwd;
    private String phone;
    private String address;
    private String grade;
    private String etc;
    
    private String seq;
    
	private String sample6_postcode;
	private String sample6_address;
	private String sample6_detailAddress;
	private String sample6_extraAddress;
}