package com.springbook.com.shop;

import lombok.Data;

@Data
public class BuyVO {	
	private int seq;
	private String memberid;
	private int product_id;
	private String product_name;
	private int amount;
}