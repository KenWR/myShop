package com.green.nowon.domain.dto;

import lombok.Data;

@Data
public class GoodsInsertDTO {
	
	private long[] categoryNo;
	private String title;
	private String[] newName;
	private int price;
	private int stock;
	private String content;

}
